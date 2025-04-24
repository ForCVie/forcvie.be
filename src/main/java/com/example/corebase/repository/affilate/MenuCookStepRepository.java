package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.MenuCookStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("menuCookStepRepository")
public interface MenuCookStepRepository extends JpaRepository<MenuCookStepEntity, String> {
    String MENU_COOK_STEP_REPOSITORY = "menuCookStepRepository";
}
