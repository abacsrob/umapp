package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.common.UmService;
import com.restcourse.umapp.repository.PrivilegeRepository;
import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.PrivilegeService;
import com.restcourse.umapp.web.converter.PrivilegeToDtoConverter;
import com.restcourse.umapp.web.converter.PrivilegeToEntityConverter;
import com.restcourse.umapp.web.dto.PrivilegeDto;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl extends AbstractService<Privilege, PrivilegeDto> implements UmService<PrivilegeDto>, PrivilegeService {

    private PrivilegeRepository privilegeRepository;
    private PrivilegeToDtoConverter privilegeToDtoConverter;
    private PrivilegeToEntityConverter privilegeToEntityConverter;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository, PrivilegeToDtoConverter privilegeToDtoConverter, PrivilegeToEntityConverter privilegeToEntityConverter) {
        this.privilegeRepository = privilegeRepository;
        this.privilegeToDtoConverter = privilegeToDtoConverter;
        this.privilegeToEntityConverter = privilegeToEntityConverter;
    }

    @Override
    protected PrivilegeToDtoConverter getToDtoConverter() {
        return privilegeToDtoConverter;
    }

    @Override
    protected PrivilegeToEntityConverter getToEntityConverter() {
        return privilegeToEntityConverter;
    }

    @Override
    public PrivilegeDto findByName(final String name) {
        return getToDtoConverter().convert(getDao().findByName(name));
    }

    @Override
    public PrivilegeDto findByNameAndId(String name, Long id) {
        return getToDtoConverter().convert(getDao().findByNameAndId(name, id));
    }

    @Override
    protected PrivilegeRepository getDao() {
        return privilegeRepository;
    }
}
