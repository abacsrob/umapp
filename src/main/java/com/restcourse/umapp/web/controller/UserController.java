package com.restcourse.umapp.web.controller;

import com.restcourse.umapp.service.UserService;
import com.restcourse.umapp.web.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = {"application/json", "application/xml"})
public class UserController extends AbstractController<UserDto> {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> findAll() {
        return findAllInternal();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto findOne(@PathVariable("id") final Long id) {
        return findOneInternal(id);
    }

    @RequestMapping(params = { "page", "size", "sortBy", "sortOrder" }, method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> findAllPaginatedAndSorted(
            @RequestParam(value = "page") final int page, @RequestParam(value = "size") final int size,
            @RequestParam(value = "sortBy") final String sortBy, @RequestParam(value = "sortOrder") final String sortOrder) {
        return findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
    }

    @RequestMapping(params = { "page", "size" }, method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> findAllPaginated(@RequestParam(value = "page") final int page, @RequestParam(value = "size") final int size) {
        return findPaginatedInternal(page, size);
    }

    @RequestMapping(params = { "sortBy", "sortOrder" }, method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> findAllSorted(@RequestParam(value = "sortBy") final String sortBy, @RequestParam(value = "sortOrder") final String sortOrder) {
        return findAllSortedInternal(sortBy, sortOrder);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final UserDto resource) {
        createInternal(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody @Valid final UserDto resource) {
        updateInternal(id, resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteByIdInternal(id);
    }

    @Override
    protected UserService getService() {
        return userService;
    }
}
