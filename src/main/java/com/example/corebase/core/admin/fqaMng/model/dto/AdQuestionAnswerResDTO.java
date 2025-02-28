package com.example.corebase.core.admin.fqaMng.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdQuestionAnswerResDTO {

    private String qaSeq;

    private String title;

    private String questionDate;

    private String userQuestion;

    private String userAnswer;
}
