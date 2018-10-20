package com.github.pavelhe.repository;


import java.util.*;

import com.github.pavelhe.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @PostFilter("hasPermission(filterObject, 'READ')")
    List<User> findAll();

    @Override
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    User getOne(Long id);

    @SuppressWarnings("unchecked")
    @Override
    @PreAuthorize("hasPermission(#user, 'WRITE')")
    User save(@Param("user") User user);

    @SuppressWarnings("unchecked")
    @Override
    @PreAuthorize("hasPermission(#user, 'DELETE')")
    void delete(@Param("user") User user);

}
