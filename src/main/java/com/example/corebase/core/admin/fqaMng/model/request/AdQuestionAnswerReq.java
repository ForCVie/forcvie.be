package com.example.corebase.core.admin.fqaMng.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdQuestionAnswerReq {

    private String qaSeq;

    private String answer;
}
