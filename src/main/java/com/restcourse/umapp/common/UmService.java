package com.restcourse.umapp.common;

import com.restcourse.umapp.service.PagingAndSortingService;

public interface UmService<T extends UmDto> extends PagingAndSortingService<T>, UmSearchableByName<T> {
}
