package com.gs.greenspace.repository;

import com.gs.greenspace.entity.FormFieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormFieldRepository extends JpaRepository<FormFieldEntity, Long> {
    List<FormFieldEntity> findAllByOrderByDisplayOrderAsc();
}