package com.restcourse.umapp.web.controller;

import com.restcourse.umapp.common.IdentifiableComponent;
import com.restcourse.umapp.service.PagingAndSortingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public abstract class AbstractController<T extends IdentifiableComponent> {

    protected abstract PagingAndSortingService<T> getService();

    protected T findOneInternal(Long id) {
        return getService().findOne(id);

    }
    protected List<T> findAllInternal() {
        return getService().findAll();
    }

    protected final List<T> findAllSortedInternal(final String sortBy, final String sortOrder) {
        return getService().findAllSorted(sortBy, sortOrder);
    }

    protected final List<T> findPaginatedInternal(final int page, final int size) {
        return getService().findAllPaginated(page, size);
    }

    protected final List<T> findPaginatedAndSortedInternal(final int page, final int size, final String sortBy, final String sortOrder) {
        return getService().findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
    }

    protected final void createInternal(final T resource) {
        getService().create(resource);
    }

    protected final void updateInternal(final long id, final T resource) {
        getService().update(resource);
    }

    protected final void deleteByIdInternal(final long id) {
        getService().delete(id);
    }

    protected final long countInternal() {
        return getService().count();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return countInternal();
    }

}
