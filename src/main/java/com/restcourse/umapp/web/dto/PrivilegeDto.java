package com.restcourse.umapp.web.dto;

import com.restcourse.umapp.common.UmDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PrivilegeDto implements UmDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private String description;

    public PrivilegeDto() {
    }

    public PrivilegeDto(String name) {
        this.name = name;
        this.description = name;
    }
}
