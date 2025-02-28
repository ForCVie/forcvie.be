package com.example.corebase.core.common.service;

import com.example.corebase.core.common.service.dto.FileMngDto;
import com.example.corebase.core.common.service.dto.FileUploadedInfoDto;
import com.example.corebase.repository.common.FileMngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileMngService {

    private final FileMngRepository fileMngRepository;

    /**
     * @param fileMngDto
     * @return
     */
    @Transactional
    public List<FileMngDto> createNewFile(List<FileMngDto> fileMngDtoList) {
//        List<FileMngEntity> fileMngEntities = fileMngDtoList.stream()
//                .map(dto -> modelMapper.map(dto, FileMngEntity.class)).collect(Collectors.toList());
//        //To do: wait longin
//        for (FileMngEntity fileMngEntity : fileMngEntities) {
//
//            fileMngEntity.setLastModifiedBy("usertTest");
//            fileMngEntity.setCreatedBy("usertTest");
//        }
//        fileMngEntities = fileMngRepository.saveAll(fileMngEntities);
//        return fileMngEntities.stream()
//                .map(entity -> modelMapper.map(entity, FileMngDto.class)).collect(Collectors.toList());
        return null;
    }

    /**
     * @param fileId
     * @return
     */
    @Transactional
    public int deleteFile(long fileId) {
//        int deleteFlag = 1;
//        Instant updateDate = Instant.now();
//        //Todo:
//        String updateBy = "testUser";
//        int result = fileMngRepository.deleteByDeleteFlag(deleteFlag, updateDate, updateBy, fileId);
        return 0;
    }

    /**
     * @param fimFileCategory
     * @param fimFileOrgName
     * @param fimSectionName
     * @param fimReferKeyId
     * @return
     * @throws IOException
     */
    public List<FileUploadedInfoDto> selectFileUploaded(String fimFileCategory,
                                                        String fimFileOrgName, String fimSectionName, Long fimReferKeyId) throws IOException {
//        List<FileUploadedInfoDto> fileUploadedInfoDtos = new ArrayList<FileUploadedInfoDto>();
//        List<FileMngEntity> fileMngEntities = fileMngRepository
//                .findByFimFileCategoryAndFimFileOrgNameAndFimSectionNameAndFimReferKeyIdAndDeleteFlag(fimFileCategory,
//                        fimFileOrgName, fimSectionName, fimReferKeyId, 0);
//        FileUploadedInfoDto dto;
//        String fileUrl;
//        for (FileMngEntity fileMngEntity : fileMngEntities) {
//            dto = new FileUploadedInfoDto();
//            dto.setFimFileName(fileMngEntity.getFimFileName());
//            dto.setId(fileMngEntity.getId());
//            dto.setFimFilePath(fileMngEntity.getFimFilePath());
//            String newPath = fileMngEntity.getFimFilePath().replace(Constant.UPLOAD_FOLDER, "files");
//            fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/" + newPath + "/")
//                    .path(fileMngEntity.getFimFileName())
//                    .toUriString();
//            dto.setUrlFile(fileUrl);
//            fileUploadedInfoDtos.add(dto);
//        }

        return null;
    }
}
