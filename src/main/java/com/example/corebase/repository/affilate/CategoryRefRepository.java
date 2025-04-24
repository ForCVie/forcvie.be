package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.CategoryRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRefRepository")
public interface CategoryRefRepository extends JpaRepository<CategoryRefEntity, String> {
    String CATEGORY_REF_REPOSITORY = "categoryRefRepository";
}
