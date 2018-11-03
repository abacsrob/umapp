package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.repository.RoleRepository;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.RoleService;
import com.restcourse.umapp.web.converter.RoleToDtoConverter;
import com.restcourse.umapp.web.converter.RoleToEntityConverter;
import com.restcourse.umapp.web.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDto> implements RoleService {

    private RoleRepository roleRepository;
    private RoleToDtoConverter roleToDtoConverter;
    private RoleToEntityConverter roleToEntityConverter;

    public RoleServiceImpl(RoleRepository roleRepository, RoleToDtoConverter roleToDtoConverter, RoleToEntityConverter roleToEntityConverter) {
        this.roleRepository = roleRepository;
        this.roleToDtoConverter = roleToDtoConverter;
        this.roleToEntityConverter = roleToEntityConverter;
    }

    @Override
    protected RoleToDtoConverter getToDtoConverter() {
        return roleToDtoConverter;
    }

    @Override
    protected RoleToEntityConverter getToEntityConverter() {
        return roleToEntityConverter;
    }

    @Override
    public RoleDto findByName(final String name) {
        return getToDtoConverter().convert(getDao().findByName(name));
    }

    @Override
    protected RoleRepository getDao() {
        return roleRepository;
    }
}
