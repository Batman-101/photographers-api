package com.excel.studio.handler;

import com.excel.studio.model.ErrorModel;
import com.excel.studio.model.GenericResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ErrorModel errorModel = new ErrorModel();
        GenericResponse response = new GenericResponse();
        response.setTimestamp(Instant.now());
        errorModel.setErrorCode(105);
        errorModel.setMessage(ex.getMessage());
        response.setError(errorModel);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModel errorModel = new ErrorModel();
        GenericResponse response = new GenericResponse();
        response.setTimestamp(Instant.now());
        errorModel.setErrorCode(105);
        errorModel.setMessage(ex.getMessage());
        response.setError(errorModel);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModel errorModel = new ErrorModel();
        GenericResponse response = new GenericResponse();
        response.setTimestamp(Instant.now());
        errorModel.setErrorCode(103);
        errorModel.setMessage(ex.getMessage());
        response.setError(errorModel);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorModel errorModel = new ErrorModel();
        GenericResponse response = new GenericResponse();
        response.setTimestamp(Instant.now());
        errorModel.setErrorCode(103);
        errorModel.setMessage(ex.getMessage());
        response.setError(errorModel);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
