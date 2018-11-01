package com.restcourse.umapp.common;

public final class UmAppConstants {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASS = "adminpass";
    public static final String ADMIN_EMAIL = "admin@fake.com";

    public static final String USER_USERNAME = "user";
    public static final String USER_PASS = "userpass";
    public static final String USER_EMAIL = "user@fake.com";

    // privileges

    public static final class Privileges {

        // User
        public static final String CAN_USER_READ = "ROLE_USER_READ";
        public static final String CAN_USER_WRITE = "ROLE_USER_WRITE";

        // Role
        public static final String CAN_ROLE_READ = "ROLE_ROLE_READ";
        public static final String CAN_ROLE_WRITE = "ROLE_ROLE_WRITE";

        // Privilege
        public static final String CAN_PRIVILEGE_READ = "ROLE_PRIVILEGE_READ";
        public static final String CAN_PRIVILEGE_WRITE = "ROLE_PRIVILEGE_WRITE";

    }

    public static final class Roles {

        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_USER = "ROLE_ENDUSER";

    }

    private UmAppConstants() {
        throw new AssertionError();
    }

}
