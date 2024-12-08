package com.example.profiles.common;

import com.example.profiles.base.BaseReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CheckProcessCommon {
    public static ResponseEntity<?> isProcess(boolean isProcess) {
        try {
            if (!isProcess) {
                return ResponseEntity.badRequest().body(new BaseReponse<>(HttpStatus.BAD_REQUEST.value(), "Bad request", null));
            }
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Process Successfully!", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseReponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Process Error: " + e.getMessage(), null));
        }
    }
}
