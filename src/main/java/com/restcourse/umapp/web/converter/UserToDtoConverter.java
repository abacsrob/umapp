package com.restcourse.umapp.web.converter;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.web.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    private RoleToDtoConverter roleToDtoConverter;

    public UserToDtoConverter(RoleToDtoConverter roleToDtoConverter) {
        this.roleToDtoConverter = roleToDtoConverter;
    }

    @Override
    public UserDto convert(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setLocked(user.getLocked());
        userDto.setRoles(
                Sets.newHashSet(
                        Collections2.transform(user.getRoles(), roleToDtoConverter::convert)
                )
        );
        return userDto;
    }
}
