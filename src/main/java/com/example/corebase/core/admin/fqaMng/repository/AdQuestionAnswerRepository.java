package com.example.corebase.core.admin.fqaMng.repository;

import com.example.corebase.core.admin.fqaMng.model.dto.AdQuestionAnswerConDTO;
import com.example.corebase.core.admin.fqaMng.model.request.AdQuestionAnswerFilterReq;
import com.example.corebase.core.admin.fqaMng.model.response.AdQuestionAnswerResponse;
import com.example.corebase.entity.fqa.QAEntity;
import com.example.corebase.repository.fqa.QARepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdQuestionAnswerRepository extends QARepository {

    @Query(value = """
        SELECT 
            q.qa_seq,
            q.title,
            q.question_date,
            um.full_name as userQuestion,
            sm.full_name as userAnswer,
            FN_GET_CODE_NAME(q.status) as status
        FROM qa q 
        JOIN user_mng um ON q.user_question = um.id AND um.del_yn = :#{#con.delYn}
        LEFT JOIN staff_mng sm ON q.user_answer = sm.id AND sm.del_yn = :#{#con.delYn}
        WHERE q.temp_yn = :#{#con.delYn} 
            AND q.del_yn = :#{#con.delYn}
            AND (:#{#req.userAnswer} IS NULL OR sm.full_name = CONCAT('%', :#{#req.userAnswer}, '%'))
            AND (:#{#req.userQuestion} IS NULL OR um.full_name = CONCAT('%', :#{#req.userQuestion}, '%'))
            AND (:#{#req.status} IS NULL OR q.status = CONCAT('%', :#{#req.status}, '%'))
        ORDER BY q.created_date desc 
    """, nativeQuery = true)
    Page<AdQuestionAnswerResponse> getPageData(@Param("req")AdQuestionAnswerFilterReq req, @Param("con")AdQuestionAnswerConDTO con, Pageable pageable);

    Optional<QAEntity> findByQaSeqAndDelYn(String qaSeq, String delYn);
}
