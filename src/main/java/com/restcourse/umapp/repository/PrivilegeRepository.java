package com.restcourse.umapp.repository;

import com.restcourse.umapp.common.WithNameComponent;
import com.restcourse.umapp.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege>, WithNameComponent<Privilege> {
}