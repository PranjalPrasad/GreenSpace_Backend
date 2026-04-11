package com.gs.greenspace.repository;

import com.gs.greenspace.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    LoginEntity findByUsername(String username);
}