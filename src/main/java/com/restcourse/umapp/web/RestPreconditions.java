package com.restcourse.umapp.web;

import com.restcourse.umapp.web.exception.MyRestRequestException;

public class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static boolean checkRequestValidity(boolean check, String errorMessage) {
        if (check) {
            throw new MyRestRequestException(errorMessage);
        }
        return true;
    }
}
