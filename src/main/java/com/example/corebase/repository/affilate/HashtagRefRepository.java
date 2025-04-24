package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.HashtagRefEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("hashtagRefRepository")
public interface HashtagRefRepository extends JpaRepository<HashtagRefEntity, String> {
    String HASHTAG_REF_REPOSITORY = "hashtagRefRepository";
}
