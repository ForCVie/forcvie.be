package com.example.corebase.entity.affiliate;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArticleEntity extends AuditEntity implements Serializable {

    @Id
    private String articleSeq;

    private String content;

    private String title;

    private String description;

    private String isShow;

    private String tempYn;
}
