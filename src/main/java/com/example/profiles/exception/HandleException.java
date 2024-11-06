package com.example.profiles.exception;

import com.example.profiles.base.BaseReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //class xử lí toàn cục
public class HandleException {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException e) {
        return ResponseEntity.status(e.getHttpStatus().value()).body(new BaseReponse<>(e.getHttpStatus().value(), e.getMessage(), null));
    }
}
