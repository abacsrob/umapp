package com.restcourse.umapp.repository;

import com.restcourse.umapp.common.UmSearchableByName;
import com.restcourse.umapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, UmSearchableByName<Role> {
}
