package com.derick.repository;


import com.derick.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository/*JpaRepository*/<User,Long> {
    User findByUsername(String Username);
    Optional<User> findById(Long id);
    List<User> findAll();
}