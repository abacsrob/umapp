package com.restcourse.umapp.service;

import com.restcourse.umapp.common.UmSearchableByName;
import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.web.dto.PrivilegeDto;

public interface PrivilegeService extends PagingAndSortingService<PrivilegeDto>, UmSearchableByName<PrivilegeDto> {
}
