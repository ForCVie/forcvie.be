package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.MenuCookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("menuCookRepository")
public interface MenuCookRepository extends JpaRepository<MenuCookEntity, String> {
    String MENU_COOK_REPOSITORY = "menuCookRepository";
}
