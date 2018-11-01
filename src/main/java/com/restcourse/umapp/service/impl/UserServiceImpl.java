package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.repository.UserRepository;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByName(final String name) {
        return getDao().findByName(name);
    }

    @Override
    protected UserRepository getDao() {
        return userRepository;
    }
}
