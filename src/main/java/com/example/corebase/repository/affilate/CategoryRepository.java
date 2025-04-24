package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    String CATEGORY_REPOSITORY = "categoryRepository";
}
