package com.restcourse.umapp.common;

import java.io.Serializable;

public interface UmIdentifiable extends Serializable {
    Long getId();
    void setId(Long id);
}
