package com.example.profiles.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BaseReponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
