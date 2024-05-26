package com.hilaryd.expense_track_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

//    handle specific exceptions  like resource not found exception
    @ExceptionHandler(ResouceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResouceNotFoundException exception, WebRequest webRequest){
        var errorDetails = new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setErrorCode("RESOURCE_NOT_FOUND");
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
//HANDLE GENERIC EXCPTIONS
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDetails> handleGenericException(Exception exception, WebRequest webRequest){
        var errorDetails = new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage(exception.getMessage());
        errorDetails.setErrorCode("INTERNAL_SERVER_ERROR");
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
