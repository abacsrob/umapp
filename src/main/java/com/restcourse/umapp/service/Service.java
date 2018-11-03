package com.restcourse.umapp.service;

import com.restcourse.umapp.common.UmDto;

import java.util.List;

public interface Service<T extends UmDto> {

    T findOne(final Long id);

    List<T> findAll();

    T create(final T resource);

    void update(final T resource);

    void delete(final Long id);

    void deleteAll();

    long count();
}
