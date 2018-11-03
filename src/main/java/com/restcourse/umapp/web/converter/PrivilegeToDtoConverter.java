package com.restcourse.umapp.web.converter;

import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.web.dto.PrivilegeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeToDtoConverter implements Converter<Privilege, PrivilegeDto> {

    @Override
    public PrivilegeDto convert(Privilege privilege) {
        if (privilege == null) {
            return null;
        }
        PrivilegeDto privilegeDto = new PrivilegeDto();
        privilegeDto.setId(privilege.getId());
        privilegeDto.setName(privilege.getName());
        privilegeDto.setDescription(privilege.getDescription());
        return privilegeDto;
    }
}
