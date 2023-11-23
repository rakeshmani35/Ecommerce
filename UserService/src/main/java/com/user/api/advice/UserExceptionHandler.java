package com.user.api.advice;

import com.user.api.exception.InvalidUserException;
import com.user.api.exception.UserSessionCountExceedException;
import com.user.api.exception.UserSessionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice
public class UserExceptionHandler {

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(UserSessionNotFoundException.class)
//    public Map<String, String> handleUserSessionNotFoundException(UserSessionNotFoundException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", ex.getMessage());
//        return errorMap;
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(UserSessionNotFoundException.class)
//    public Map<String, String> handleInvalidUserFoundException(InvalidUserException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", ex.getMessage());
//        return errorMap;
//    }
//
//    @ResponseStatus(HttpStatus.MULTI_STATUS)
//    @ExceptionHandler(UserSessionCountExceedException.class)
//    public Map<String, String> handleInvalidUserFoundException(UserSessionCountExceedException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", ex.getMessage());
//        return errorMap;
//    }
}
