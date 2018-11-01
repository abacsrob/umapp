package com.restcourse.umapp.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.restcourse.umapp.common.UmAppConstants;
import com.restcourse.umapp.entity.Privilege;
import com.restcourse.umapp.entity.Role;
import com.restcourse.umapp.entity.User;
import com.restcourse.umapp.service.PrivilegeService;
import com.restcourse.umapp.service.RoleService;
import com.restcourse.umapp.service.UserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UmRepositoryInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private PrivilegeService privilegeService;
    private RoleService roleService;
    private UserService userService;

    private boolean doneFlag = false;

    public UmRepositoryInitializer(PrivilegeService privilegeService, RoleService roleService, UserService userService) {
        this.privilegeService = privilegeService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!doneFlag) {
            createPrivileges();
            createRoles();
            createUsers();
            doneFlag = true;
        }
    }

    private void createPrivileges() {
        Lists.newArrayList(
                new Privilege(UmAppConstants.Privileges.CAN_USER_READ),
                new Privilege(UmAppConstants.Privileges.CAN_USER_WRITE),
                new Privilege(UmAppConstants.Privileges.CAN_ROLE_READ),
                new Privilege(UmAppConstants.Privileges.CAN_ROLE_WRITE),
                new Privilege(UmAppConstants.Privileges.CAN_PRIVILEGE_READ),
                new Privilege(UmAppConstants.Privileges.CAN_PRIVILEGE_WRITE)
        ).forEach(privilege -> privilegeService.create(privilege));
    }

    private void createRoles() {
        final Privilege privilegeCanUserRead = privilegeService.findByName(UmAppConstants.Privileges.CAN_USER_READ);
        final Privilege privilegeCanUserWrite = privilegeService.findByName(UmAppConstants.Privileges.CAN_USER_WRITE);
        final Privilege privilegeCanRoleRead = privilegeService.findByName(UmAppConstants.Privileges.CAN_ROLE_READ);
        final Privilege privilegeCanRoleWrite = privilegeService.findByName(UmAppConstants.Privileges.CAN_ROLE_WRITE);
        final Privilege privilegeCanPrivilegeRead = privilegeService.findByName(UmAppConstants.Privileges.CAN_PRIVILEGE_READ);
        final Privilege privilegeCanPrivilegeWrite = privilegeService.findByName(UmAppConstants.Privileges.CAN_PRIVILEGE_WRITE);

        Lists.newArrayList(
                new Role(
                        UmAppConstants.Roles.ROLE_USER,
                        Sets.newHashSet(
                                privilegeCanUserRead,
                                privilegeCanRoleRead,
                                privilegeCanPrivilegeRead
                        )
                ),
                new Role(
                        UmAppConstants.Roles.ROLE_ADMIN,
                        Sets.newHashSet(
                                privilegeCanUserRead,
                                privilegeCanRoleRead,
                                privilegeCanPrivilegeRead,
                                privilegeCanUserWrite,
                                privilegeCanRoleWrite,
                                privilegeCanPrivilegeWrite
                        )
                )
        ).forEach(role -> roleService.create(role));
    }

    private void createUsers() {
        final Role roleUser = roleService.findByName(UmAppConstants.Roles.ROLE_USER);
        final Role roleAdmin = roleService.findByName(UmAppConstants.Roles.ROLE_ADMIN);

        Lists.newArrayList(
                new User(UmAppConstants.USER_USERNAME, UmAppConstants.USER_PASS, Sets.newHashSet(roleUser)),
                new User(UmAppConstants.ADMIN_USERNAME, UmAppConstants.ADMIN_PASS, Sets.newHashSet(roleAdmin))
        ).forEach(user -> userService.create(user));
    }
}
