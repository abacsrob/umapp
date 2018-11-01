package com.restcourse.umapp.web;

import com.restcourse.umapp.common.RestError;
import com.restcourse.umapp.web.exception.MyRestRequestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, generateRestError(status, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, generateRestError(status, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { DataIntegrityViolationException.class, MyRestRequestException.class })
    public final ResponseEntity<Object> handleDataIntegrityViolationException(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, generateRestError(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private RestError generateRestError(final HttpStatus httpStatus, final Exception ex) {
        final String message = ex.getMessage() != null ? ex.getMessage() : ex.getClass().getSimpleName();
//        final String devMessage = ex.getClass().getSimpleName();
        final String devMessage = ExceptionUtils.getRootCauseMessage(ex);
        return new RestError(httpStatus.value(), message, devMessage);
    }
}
