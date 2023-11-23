package com.user.api.service;

import com.user.api.entity.Session;
import com.user.api.entity.User;
import com.user.api.repository.SessionRepository;
import com.user.api.repository.UserRepository;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;


class AuthServiceImplTest {

//    @InjectMocks
//    AuthServiceImpl authService;
//
//    @Mock
//    UserRepository userRepository;
//
//    @Mock
//    SessionRepository sessionRepository;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testLogin() {
//     // Arrange
//        User user = new User();
//        user.setId(10L);
//        user.setName("JUNIT");
//        user.setEmail("JUNIT@junit.com");
//        user.setSession(null);
//        user.setPassword("passowrd");
//
//    }
//
//    @Test
//    void validate() {
//    }


}