package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.MenuCookStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCookStepRepository extends JpaRepository<MenuCookStepEntity, String> {
}
