package com.scm.scm2_0.repositories;

import com.scm.scm2_0.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // extra methods db related Operations
    // custom query methods
    // custom finder methods
    Optional<User> findByEmail(String email);
}
