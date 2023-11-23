package com.user.api.service;

import com.user.api.dto.UserDto;
import com.user.api.entity.SessionStatus;
import com.user.api.entity.User;
import com.user.api.exception.*;
import org.springframework.http.ResponseEntity;

public interface AuthService {

//    public User login(User user) throws InvalidUserException, UserSessionCountExceedException;
//
//    public User validate(Long userId, String token) throws UserSessionNotFoundException;

    public ResponseEntity<UserDto> login(String email, String password) throws UserDoesNotExistException;

    public ResponseEntity<Void> logout(String token, Long userId);

    public UserDto signUp(String email, String password) throws UserAlreadyExistsException;

    public SessionStatus validate(String token, Long userId);
}
