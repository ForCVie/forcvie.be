package com.example.corebase.repository.common;

import com.example.corebase.entity.common.FileMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMngRepository extends JpaRepository<FileMngEntity, String> {

    List<FileMngEntity> findByFimReferKeyId(String fimReferKeyId);

    FileMngEntity findByFimFileNameAndDelYn(String fimFileName, String deleteFlag);

    List<FileMngEntity> findByFimReferKeyIdAndFimFileCategoryAndDelYn(String fimReferKeyId, String fimFileCategory,
                                                                           String deleteFlag);

    List<FileMngEntity> findByFimReferKeyIdInAndFimSectionNameInAndDelYn(List<String> referKeys,
                                                                              List<String> sectionNames, String deleteFlag);
}
