package com.example.corebase.repository.common;

import com.example.corebase.entity.common.CodeMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeMngRepository extends JpaRepository<CodeMngEntity, String> {

    @Query(value = """
                select cd_id as cdId, cd_key as cdKey , cd_name as cdName, up_cd_id as type from code_mng cm where up_cd_id in :listCdCategory
            """, nativeQuery = true)
    List<CodeMngResponse> findByUpCdIdIn(@Param("listCdCategory") List<String> listCdCategory);

    interface CodeMngResponse {
        String getCdId();

        String getCdKey();

        String getCdName();

        String getType();
    }
}
