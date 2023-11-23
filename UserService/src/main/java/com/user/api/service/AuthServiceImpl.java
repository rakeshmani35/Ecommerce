package com.user.api.service;

import com.user.api.dto.UserDto;
import com.user.api.entity.Session;
import com.user.api.entity.SessionStatus;
import com.user.api.entity.User;
import com.user.api.exception.UserAlreadyExistsException;
import com.user.api.exception.UserDoesNotExistException;
import com.user.api.repository.SessionRepository;
import com.user.api.repository.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    SessionRepository sessionRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<UserDto> login(String email, String password) throws UserDoesNotExistException {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new UserDoesNotExistException("User with email: " + email + " doesn't exist.");
        }

        User user = userOptional.get();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        String token = RandomStringUtils.randomAscii(20); // generate token

        String jwtToken = generateToken(user);
        System.out.println("jwtToken = "+jwtToken);

        Session session = new Session();
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setToken(token);
        session.setUser(user);
        sessionRepository.save(session); // store session in DB

        UserDto userDto = UserDto.from(user);
        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add("AUTH_TOKEN", token);
        ResponseEntity<UserDto> response = new ResponseEntity<>(userDto, headers, HttpStatus.OK);

        return response;
    }

    @Override
    public ResponseEntity<Void> logout(String token, Long userId) {

        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUser_Id(token, userId);
        if (sessionOptional.isEmpty()) {
            return null;
        }

        Session session = sessionOptional.get();
        session.setSessionStatus(SessionStatus.LOGGED_OUT); // soft delete
        sessionRepository.save(session);

        return ResponseEntity.ok().build();
    }

    @Override
    public UserDto signUp(String email, String password) throws UserAlreadyExistsException {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User with " + email + " already exists.");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);


        return UserDto.from(user);
    }

    @Override
    public SessionStatus validate(String token, Long userId) {
        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUser_Id(token, userId);
        if (sessionOptional.isEmpty()) {
            return SessionStatus.INVALID;
        }

        Session session = sessionOptional.get();
        if (!SessionStatus.ACTIVE.equals(session.getSessionStatus())) {
            return SessionStatus.EXPIRED;
        }

        return SessionStatus.ACTIVE;
    }

    private String generateToken(User user) {
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("user-email", user.getEmail());
        claimsMap.put("user-role", user.getRoles());


        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        String secret = "scalerscalerscalerscalerscalerscalerscalerscalerscalerscaler";

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claimsMap)
                .setHeader(headerMap)
                .signWith(SignatureAlgorithm.HS256, secret);

        return jwtBuilder.compact();
    }

}
