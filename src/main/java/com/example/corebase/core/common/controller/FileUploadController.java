package com.example.corebase.core.common.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.common.service.FileMngService;
import com.example.corebase.core.common.service.dto.FileMngDto;
import com.example.corebase.core.common.service.dto.FileUploadedInfoDto;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value = {"/cmm/files"})
@RequiredArgsConstructor
public class FileUploadController {

    // List ALLOWED EXTENSIONS of file
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(".hwp", ".hwpx", ".doc", ".docx", ".xls",
            ".xlsx", ".ppt", ".pptx", ".txt", ".pdf", ".zip", ".jpg", ".png", ".jpeg", ".avi" , ".flv" , ".mkv" , ".mov" , ".mpeg",
            ".mp4" , ".ogg", ".wma", ".wmv");

    private final FileMngService fileMngService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private LanguageCommon languageCommon;

    private Path fileStorageLocation;

    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    @PostConstruct
    public void init() {
        this.fileStorageLocation = Paths.get(uploadPath).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

    /**
     * Upload file
     *
     * @param files       .
     * @param category    .
     * @param orgName     .
     * @param sectionName .
     * @param referKeyId  .
     * @return FileMngDto
     * @throws IOException .
     */
    @PostMapping (value = "upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseObject<List<FileMngDto>> uploadFile(@RequestParam ("files") MultipartFile[] files,
                                                    @RequestParam ("category") String category, @RequestParam ("orgName") String orgName,
                                                    @RequestParam ("sectionName") String sectionName, @RequestParam ("referKeyId") String referKeyId) throws
            IOException {

        if (files.length == 1 && files[ 0 ].getOriginalFilename().isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound"));
        }

        List<FileMngDto> listFileMngDto = new ArrayList<FileMngDto>();
        List<FileMngDto> fileRes = new ArrayList<FileMngDto>();

        for (MultipartFile file : files) {

            String fileExtension = getFileExtension(file.getOriginalFilename());
            if (! ALLOWED_EXTENSIONS.contains(fileExtension.toLowerCase())) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound"));
            }

            FileMngDto fileMngDto = new FileMngDto();
            fileMngDto = fileMngService.uploadFile(file, category, orgName, sectionName);
            fileMngDto.setFimReferKeyId(referKeyId);
            listFileMngDto.add(fileMngDto);
            fileRes = fileMngService.createNewFile(listFileMngDto);
        }

        return new ResponseObject<>(fileRes);
    }

    /**
     * Upload file with editor
     *
     * @param file        .
     * @param category    .
     * @param orgName     .
     * @param sectionName .
     * @return FileUploadedInfoDto
     * @throws IOException .
     */
    @PostMapping (value = "uploadEditer", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseObject<FileUploadedInfoDto> uploadEditer(@RequestParam ("file") MultipartFile file,
                                                         @RequestParam ("category") String category, @RequestParam ("orgName") String orgName,
                                                         @RequestParam ("sectionName") String sectionName) throws IOException {

        if (file == null) {
            throw new BadRequestCustomException("message.error.file.bad.request");
        }

        FileMngDto fileMngDto = fileMngService.uploadFile(file, category, orgName, sectionName);
        FileUploadedInfoDto fileUploadedInfoDto = fileMngService.createEditNewFile(fileMngDto);

        return new ResponseObject<>(fileUploadedInfoDto);
    }

    /**
     * Download single file
     *
     * @body SingleFileDTO .
     * @return ResponseEntity<Resource> .
     * @throws IOException .
     */
//    @PostMapping ("/download")
//    public ResponseEntity<Resource> downloadFile(@RequestBody SingleFileDTO singleFileDTO) throws
//            IOException {
//
//        if (singleFileDTO.getEncodedFileName().isEmpty()) {
//            throw new BadRequestCustomException("message.error.file.empty");
//        }
//
//        Resource resource = fileMngService.prepareDownloadSingleFile(singleFileDTO.getEncodedFileName());
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .contentLength(resource.getFile().length()).contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }

    /**
     * Download multiple file
     *
     * @param multipleFileDTO .
     * @return ResponseEntity<Resource>
     */
//    @PostMapping ("/downloadMultiple")
//    public ResponseEntity<Resource> downloadFiles(@RequestBody MultipleFileDTO multipleFileDTO) {
//        try {
//            List<String> referKeys = multipleFileDTO.getFimReferKeyIdList();
//            List<String> sectionNames = multipleFileDTO.getFimSectionName();
//            Resource resource = fileMngService.prepareDownloadFiles(referKeys, sectionNames);
//
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .contentLength(resource.getFile().length()).contentType(MediaType.APPLICATION_OCTET_STREAM)
//                    .body(resource);
//        } catch (IOException e) {
//            throw new BadRequestCustomException("message.error");
//        }
//    }

    /**
     * Get a list of file information
     *
     * @return List<FileUploadedInfoDto>
     * @throws IOException .
     */
    @PostMapping ("/fileUploadedInfo")
    public ResponseObject<List<FileUploadedInfoDto>> getFileUploadedInfo(@RequestBody FileMngDto fileDto) throws IOException {

        List<FileUploadedInfoDto> fileUploadedInfoDtos = fileMngService.selectFileUploaded(fileDto);
        return new ResponseObject<>(fileUploadedInfoDtos);
    }

    /**
     * Delete file
     *
     * @param encodedFileName .
     * @return String
     */
    @PutMapping ("/fileMng/{encodedFileName}")
    public ResponseObject<String> deleteUploadedFile(@PathVariable String encodedFileName) {
        try {
            String deletedFileId = fileMngService.deleteUploadedFile(encodedFileName);

            return new ResponseObject<>(encodedFileName);
        } catch (FileNotFoundException e) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.error.file.not.found"));
        } catch (IOException e) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.error"));
        }
    }
}
