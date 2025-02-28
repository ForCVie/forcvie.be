package com.example.corebase.entity;

import com.example.corebase.entity.base.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "qa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QAEntity extends AuditEntity implements Serializable {

    @Id
    private String qaSeq;

    private String title;

    private String question;

    private String answer;

    private LocalDateTime questionDate;

    private LocalDateTime answerDate;

    private String userQuestion;

    private String userAnswer;

    private String tempYn;

    private String status;
}
