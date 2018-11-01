package com.restcourse.umapp.common;

public interface WithNameComponent<T extends NameableComponent> {
    T findByName(final String name);
}
