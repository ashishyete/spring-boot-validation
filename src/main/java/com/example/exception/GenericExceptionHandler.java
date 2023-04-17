package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ResponseException responseException = new ResponseException(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ResponseException responseException = new ResponseException(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                e->{
                    errorMap.put(e.getField(),e.getDefaultMessage());
                });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
}
