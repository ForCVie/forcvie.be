package com.example.corebase.repository.common;

import com.example.corebase.entity.common.FileMngEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMngRepository extends JpaRepository<FileMngEntity, String> {

    List<FileMngEntity> findByProducerIdAndProducerCodeAndDelYn(String producerId, String fileType, String delYn);

    FileMngEntity findByFileNameAndDelYn(String fileName, String delYn);

    List<FileMngEntity> findByProducerIdInAndFileNameInAndDelYn(List<String> producerIds, List<String> fileName, String delYn);
}
