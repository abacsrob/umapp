package com.restcourse.umapp.web.dto;

import com.restcourse.umapp.common.UmDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class UserDto implements UmDto {

    private Long id;

    @NotNull
    private String name;
    private String password;
    private Boolean locked;

    @NotNull
    @Email
    private String email;

    @Min(0)
    @Max(99)
    private int age;

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
