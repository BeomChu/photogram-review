package com.cos.photogramstart.repository;

import com.cos.photogramstart.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);
    User findByUsername(String username);


}