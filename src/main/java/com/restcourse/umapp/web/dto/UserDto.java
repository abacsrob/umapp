package com.restcourse.umapp.web.dto;

import com.restcourse.umapp.common.UmDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
public class UserDto implements UmDto {

    private Long id;
    private String name;
    private String password;
    private Boolean locked;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<RoleDto> roles;

    public UserDto() {
    }

    public UserDto(String name, String password, Set<RoleDto> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}
