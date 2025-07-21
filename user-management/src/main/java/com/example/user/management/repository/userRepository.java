package com.example.user.management.repository;

import com.example.user.management.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface userRepository extends CrudRepository<UserApp, Long> {
 Optional<UserApp> findByUsername(String username);
}