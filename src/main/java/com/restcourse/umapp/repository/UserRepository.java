package com.restcourse.umapp.repository;

import com.restcourse.umapp.common.WithNameComponent;
import com.restcourse.umapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, WithNameComponent<User> {
}
