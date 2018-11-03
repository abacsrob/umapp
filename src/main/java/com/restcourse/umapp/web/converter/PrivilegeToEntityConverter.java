package com.restcourse.umapp.web.converter;

import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.web.dto.PrivilegeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeToEntityConverter implements Converter<PrivilegeDto, Privilege> {

    @Override
    public Privilege convert(PrivilegeDto privilegeDto) {
        if (privilegeDto == null) {
            return null;
        }
        Privilege privilege = new Privilege();
        privilege.setId(privilegeDto.getId());
        privilege.setName(privilegeDto.getName());
        privilege.setDescription(privilegeDto.getDescription());
        return privilege;
    }
}
