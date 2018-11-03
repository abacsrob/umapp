package com.restcourse.umapp.web.converter;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.web.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToDtoConverter implements Converter<Role, RoleDto> {

    private PrivilegeToDtoConverter privilegeToDtoConverter;

    public RoleToDtoConverter(PrivilegeToDtoConverter privilegeToDtoConverter) {
        this.privilegeToDtoConverter = privilegeToDtoConverter;
    }

    @Override
    public RoleDto convert(Role role) {
        if (role == null) {
            return null;
        }
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setPrivileges(
                Sets.newHashSet(
                        Collections2.transform(role.getPrivileges(), privilegeToDtoConverter::convert)
                )
        );
        return roleDto;
    }
}
