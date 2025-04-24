package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.HashtagMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("hashtagMngRepository")
public interface HashtagMngRepository extends JpaRepository<HashtagMngEntity, String> {
    String HASHTAG_MNG_REPOSITORY = "hashtagMngRepository";
}
