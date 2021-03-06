package com.restcourse.umapp.web.controller;

import com.restcourse.umapp.common.UmDto;
import com.restcourse.umapp.common.UmService;
import com.restcourse.umapp.web.RestPreconditions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public abstract class AbstractController<T extends UmDto> {

    protected abstract UmService<T> getService();

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
        String resourceType = resource.getClass().getSimpleName();
        RestPreconditions.checkRequestValidity(
                resource == null,
                "Cannot create a " + resourceType + " resource because the resource is null!");
        RestPreconditions.checkRequestValidity(
                getService().findByName(resource.getName()) != null,
                "Cannot create a " + resourceType + " resource because a nameable resource with the given name already exists in the database!");
        getService().create(resource);
    }

    protected final void updateInternal(final long id, final T resource) {
        String resourceType = resource.getClass().getSimpleName();
        RestPreconditions.checkRequestValidity(
                resource == null,
                "The resource is null!");
        RestPreconditions.checkRequestValidity(
                getService().findOne(id) == null,
                "The " + resourceType + " resource with id=" + id + " does not exist on the server!");
        RestPreconditions.checkRequestValidity(
                id != resource.getId(),
                "The " + resourceType + " id and the request URI id don't match!");
        RestPreconditions.checkRequestValidity(
                getService().findByNameAndId(resource.getName(), resource.getId()) == null &&
                getService().findByName(resource.getName()) != null,
                "Cannot update a " + resourceType + " resource because a nameable resource with the given name already exists in the database!");
        getService().update(resource);
    }

    protected final void deleteByIdInternal(final long id) {
        RestPreconditions.checkRequestValidity(
                getService().findOne(id) == null,
                "The requested resource with id=" + id + " does not exist on the server. Cannot delete!");
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
