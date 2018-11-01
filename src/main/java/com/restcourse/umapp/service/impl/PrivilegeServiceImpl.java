package com.restcourse.umapp.service.impl;

import com.restcourse.umapp.repository.PrivilegeRepository;
import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.service.AbstractService;
import com.restcourse.umapp.service.PrivilegeService;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements PrivilegeService {

    private PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege findByName(final String name) {
        return getDao().findByName(name);
    }

    @Override
    protected PrivilegeRepository getDao() {
        return privilegeRepository;
    }
}
