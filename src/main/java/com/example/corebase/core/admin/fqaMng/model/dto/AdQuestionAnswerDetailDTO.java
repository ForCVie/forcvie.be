package com.example.corebase.core.admin.fqaMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdQuestionAnswerDetailDTO {

    private String qaSeq;

    private String title;

    private String question;

    private String answer;

    private LocalDateTime questionDate;

    private LocalDateTime answerDate;

    private String userQuestion;

    private String userAnswer;
}
