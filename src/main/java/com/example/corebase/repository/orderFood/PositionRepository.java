package com.example.corebase.repository.orderFood;

import com.example.corebase.entity.orderFood.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("positionRepository")
public interface PositionRepository extends JpaRepository<PositionEntity, String> {
    String POSITION_REPOSITORY = "positionRepository";
}
