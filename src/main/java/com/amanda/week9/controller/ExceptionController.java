package com.amanda.week9.controller;

import com.amanda.week9.exception.PostAlreadyLikedException;
import com.amanda.week9.exception.PostNotFoundException;
import com.amanda.week9.exception.UserNotFoundException;
import com.amanda.week9.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage() , HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(exceptionResponse , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object>   postNotFoundException(PostNotFoundException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PostAlreadyLikedException.class)
    public ResponseEntity<Object>   postNotFoundException(PostAlreadyLikedException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.FORBIDDEN);
    }






}
