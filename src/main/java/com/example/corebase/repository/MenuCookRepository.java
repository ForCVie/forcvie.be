package com.example.corebase.repository;

import com.example.corebase.entity.MenuCookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCookRepository extends JpaRepository<MenuCookEntity, String> {
}
