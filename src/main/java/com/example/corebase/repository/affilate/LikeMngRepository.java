package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.LikeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("likeMngRepository")
public interface LikeMngRepository extends JpaRepository<LikeMngEntity, String> {
    String LIKE_MNG_REPOSITORY = "likeMngRepository";
}
