package com.example.corebase.repository.affilate;

import com.example.corebase.entity.affiliate.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
    String ARTICLE_REPOSITORY = "articleRepository";
}
