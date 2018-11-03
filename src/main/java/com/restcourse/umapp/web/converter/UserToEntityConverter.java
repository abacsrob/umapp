package com.restcourse.umapp.web.converter;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.web.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToEntityConverter implements Converter<UserDto, User> {

    private RoleToEntityConverter roleToEntityConverter;

    public UserToEntityConverter(RoleToEntityConverter roleToEntityConverter) {
        this.roleToEntityConverter = roleToEntityConverter;
    }

    @Override
    public User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setLocked(userDto.getLocked());
        user.setRoles(
                Sets.newHashSet(
                        Collections2.transform(userDto.getRoles(), roleToEntityConverter::convert)
                )
        );
        return user;
    }
}
