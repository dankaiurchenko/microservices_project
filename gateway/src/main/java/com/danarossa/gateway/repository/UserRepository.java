package com.danarossa.gateway.repository;

import com.danarossa.gateway.data.Role;
import com.danarossa.gateway.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findByRole(Role student);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

