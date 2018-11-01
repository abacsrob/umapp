package com.restcourse.umapp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestError {
    private int httpStatus;
    private String message;
    private String devMessage;
}
