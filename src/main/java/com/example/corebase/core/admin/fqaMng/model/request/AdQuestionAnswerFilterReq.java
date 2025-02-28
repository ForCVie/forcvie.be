package com.example.corebase.core.admin.fqaMng.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdQuestionAnswerFilterReq extends PageableRequest {

    private String userAnswer;
}
