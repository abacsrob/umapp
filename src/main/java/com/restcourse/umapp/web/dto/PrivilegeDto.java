package com.restcourse.umapp.web.dto;

import com.restcourse.umapp.common.UmDto;
import lombok.Data;

@Data
public class PrivilegeDto implements UmDto {

    private Long id;
    private String name;
    private String description;

    public PrivilegeDto() {
    }

    public PrivilegeDto(String name) {
        this.name = name;
        this.description = name;
    }
}
