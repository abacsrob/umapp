package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.repository.UserRepository;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.UserService;
import com.restcourse.umapp.web.converter.UserToDtoConverter;
import com.restcourse.umapp.web.converter.UserToEntityConverter;
import com.restcourse.umapp.web.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService {

    private UserRepository userRepository;
    private UserToDtoConverter userToDtoConverter;
    private UserToEntityConverter userToEntityConverter;

    public UserServiceImpl(UserRepository userRepository, UserToDtoConverter userToDtoConverter, UserToEntityConverter userToEntityConverter) {
        this.userRepository = userRepository;
        this.userToDtoConverter = userToDtoConverter;
        this.userToEntityConverter = userToEntityConverter;
    }

    @Override
    protected UserToDtoConverter getToDtoConverter() {
        return userToDtoConverter;
    }

    @Override
    protected UserToEntityConverter getToEntityConverter() {
        return userToEntityConverter;
    }

    @Override
    public UserDto findByName(final String name) {
        return getToDtoConverter().convert(getDao().findByName(name));
    }

    @Override
    protected UserRepository getDao() {
        return userRepository;
    }
}
