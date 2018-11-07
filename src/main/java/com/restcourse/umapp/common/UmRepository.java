package com.restcourse.umapp.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UmRepository <T extends UmEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T>, UmSearchableByName<T> {
}
