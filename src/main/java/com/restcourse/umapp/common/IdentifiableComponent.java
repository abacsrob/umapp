package com.restcourse.umapp.common;

import java.io.Serializable;

public interface IdentifiableComponent extends Serializable {
    Long getId();
    void setId(Long id);
}
