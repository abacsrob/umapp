package com.restcourse.umapp.web.dto;

import com.restcourse.umapp.common.UmDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
public class RoleDto implements UmDto {

    private Long id;
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<PrivilegeDto> privileges;

    public RoleDto() {
    }

    public RoleDto(String name, Set<PrivilegeDto> privileges) {
        this.name = name;
        this.privileges = privileges;
    }
}
