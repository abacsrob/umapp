package com.restcourse.umapp.common;

public interface UmSearchableByName<T extends UmNameable> {
    T findByName(final String name);
}
