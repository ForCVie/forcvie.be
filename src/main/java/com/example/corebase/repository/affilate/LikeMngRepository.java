package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.LikeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeMngRepository extends JpaRepository<LikeMngEntity, String> {
}
