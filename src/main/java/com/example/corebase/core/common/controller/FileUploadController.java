package com.example.corebase.core.common.controller;

import com.example.corebase.core.common.service.FileMngService;
import com.example.corebase.core.common.service.FileUploadService;
import com.example.corebase.core.common.service.dto.FileMngDto;
import com.example.corebase.core.common.service.dto.FileUploadedInfoDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;
    private final FileMngService fileMngService;

    /**
     * 
     * @param files
     * @param category
     * @param orgName
     * @param sectionName
     * @param referKeyId
     * @return
     * @throws IOException
     */
    @PostMapping(value = "upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public List<FileMngDto> uploadFile(@RequestParam("files") MultipartFile files[], @RequestParam("category") String category,
                                       @RequestParam("orgName") String orgName, @RequestParam("sectionName") String sectionName,
                                       @RequestParam("referKeyId") String referKeyId) throws IOException {
        if (files.length == 0) {
            throw new BadRequestException("File is empty");
        }
        FileMngDto fileMngDto;
        int fileSubId = 0;
        List<FileMngDto> listFileMngDto = new ArrayList<FileMngDto>();
        for (MultipartFile file : files) {
            fileSubId++;
            fileMngDto = new FileMngDto();
            fileMngDto = fileUploadService.uploadFile(file, category);
            fileMngDto.setFimReferKeyId(Long.parseLong(referKeyId));
            fileMngDto.setFimSectionName(sectionName);
            fileMngDto.setFimFileOrgName(orgName);
            fileMngDto.setFimSubFileId(fileSubId);
            listFileMngDto.add(fileMngDto);
        }
        return fileMngService.createNewFile(listFileMngDto);
    }

    /**
     * 
     * @param fileName
     * @param uploadDirectory
     * @return
     * @throws IOException
     */
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName,
            @RequestParam("uploadDirectory") String uploadDirectory) throws IOException {
        if (fileName.isEmpty()) {
            throw new BadRequestException("File name is empty");
        }

        Resource file = fileUploadService.downloadFile(fileName, uploadDirectory);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    /**
     * 
     * @param fimFileCategory
     * @param fimFileOrgName
     * @param fimSectionName
     * @param fimReferKeyId
     * @return
     * @throws IOException
     */
    @GetMapping("/fileUploadedInfo")
    public List<FileUploadedInfoDto> getFileUploadedInfo(@RequestParam(name = "fimFileCategory") String fimFileCategory,
                                                         @RequestParam(name = "fimFileOrgName") String fimFileOrgName,
                                                         @RequestParam(name = "fimSectionName") String fimSectionName,
                                                         @RequestParam(name = "fimReferKeyId") Long fimReferKeyId) throws IOException {
        List<FileUploadedInfoDto> fileUploadedInfoDtos = fileMngService.selectFileUploaded(fimFileCategory,
                fimFileOrgName, fimSectionName, fimReferKeyId);
        return fileUploadedInfoDtos;
    }

    /**
     * 
     * @param fileId
     * @return
     */
    @PutMapping("/fileMng")
    public int deleteFileUploadedInfo(@RequestParam(name = "fileId") long fileId) {
        return fileMngService.deleteFile(fileId);

    }
}
