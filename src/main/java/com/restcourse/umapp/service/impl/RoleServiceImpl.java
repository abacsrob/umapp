package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.repository.RoleRepository;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(final String name) {
        return getDao().findByName(name);
    }

    @Override
    protected RoleRepository getDao() {
        return roleRepository;
    }
}
