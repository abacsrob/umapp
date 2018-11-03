package com.restcourse.umapp.service;

import com.restcourse.umapp.common.UmSearchableByName;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.web.dto.RoleDto;

public interface RoleService extends PagingAndSortingService<RoleDto>, UmSearchableByName<RoleDto> {
}
