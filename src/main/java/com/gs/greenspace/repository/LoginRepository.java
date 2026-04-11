package com.gs.greenspace.repository;

import com.gs.greenspace.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    Optional<LoginEntity> findByUsername(String username);

    // Remove or keep the old method
    // Optional<LoginEntity> findByUsernameAndPassword(String username, String password);
}