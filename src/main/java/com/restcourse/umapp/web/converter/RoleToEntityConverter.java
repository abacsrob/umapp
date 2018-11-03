package com.restcourse.umapp.web.converter;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.web.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToEntityConverter implements Converter<RoleDto, Role> {

    private PrivilegeToEntityConverter privilegeToEntityConverter;

    public RoleToEntityConverter(PrivilegeToEntityConverter privilegeToEntityConverter) {
        this.privilegeToEntityConverter = privilegeToEntityConverter;
    }

    @Override
    public Role convert(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        role.setPrivileges(
                Sets.newHashSet(
                        Collections2.transform(roleDto.getPrivileges(), privilegeToEntityConverter::convert)
                )
        );
        return role;
    }
}
