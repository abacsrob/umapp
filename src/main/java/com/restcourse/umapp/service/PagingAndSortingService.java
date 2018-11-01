package com.restcourse.umapp.service;

import com.restcourse.umapp.common.IdentifiableComponent;

import java.util.List;

public interface PagingAndSortingService<T extends IdentifiableComponent> extends Service<T> {

    List<T> findAllSorted(final String sortBy, final String sortOrder);

    List<T> findAllPaginated(final int page, final int size);

    List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

}
