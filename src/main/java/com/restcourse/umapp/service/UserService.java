package com.restcourse.umapp.service;

import com.restcourse.umapp.common.UmSearchableByName;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.web.dto.UserDto;

public interface UserService extends PagingAndSortingService<UserDto>, UmSearchableByName<UserDto> {
}
