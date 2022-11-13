package com.bsale.store.controller;

import com.bsale.store.exception.ResourceNotFoundEx;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@NoArgsConstructor
@ResponseBody
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundEx.class)
    public ResponseEntity<Object> catchProductNotFound(ResourceNotFoundEx ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }
}
