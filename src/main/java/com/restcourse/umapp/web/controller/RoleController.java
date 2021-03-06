package com.restcourse.umapp.web.controller;

import com.restcourse.umapp.service.RoleService;
import com.restcourse.umapp.web.dto.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/roles", produces = {"application/json", "application/xml"})
public class RoleController extends AbstractController<RoleDto> {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RoleDto> findAll() {
        return findAllInternal();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RoleDto findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(params = { "page", "size", "sortBy", "sortOrder" }, method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDto> findAllPaginatedAndSorted(
            @RequestParam(value = "page") final int page, @RequestParam(value = "size") final int size,
            @RequestParam(value = "sortBy") final String sortBy, @RequestParam(value = "sortOrder") final String sortOrder) {
        return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
    }

    @RequestMapping(params = { "page", "size" }, method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDto> findAllPaginated(@RequestParam(value = "page") final int page, @RequestParam(value = "size") final int size) {
        return findPaginatedInternal(page, size);
    }

    @RequestMapping(params = { "sortBy", "sortOrder" }, method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDto> findAllSorted(@RequestParam(value = "sortBy") final String sortBy, @RequestParam(value = "sortOrder") final String sortOrder) {
        return findAllSortedInternal(sortBy, sortOrder);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final RoleDto resource) {
        createInternal(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody @Valid final RoleDto resource) {
        updateInternal(id, resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }

    @Override
    protected RoleService getService() {
        return roleService;
    }
}
