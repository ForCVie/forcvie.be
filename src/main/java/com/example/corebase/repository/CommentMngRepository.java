package com.example.corebase.repository;

import com.example.corebase.entity.CommentMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMngRepository extends JpaRepository<CommentMngEntity, String> {
}
