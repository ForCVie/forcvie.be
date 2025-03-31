package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.CommentMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMngRepository extends JpaRepository<CommentMngEntity, String> {
}
