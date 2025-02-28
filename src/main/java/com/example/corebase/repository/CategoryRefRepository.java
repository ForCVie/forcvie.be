package com.example.corebase.repository;

import com.example.corebase.entity.CategoryRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRefRepository extends JpaRepository<CategoryRefEntity, String> {
}
