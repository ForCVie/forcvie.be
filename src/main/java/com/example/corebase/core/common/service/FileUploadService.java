package com.example.corebase.core.common.service;

import com.example.corebase.core.common.service.dto.FileMngDto;
import com.example.corebase.infrastructure.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileUploadService {

    private final Logger log = LoggerFactory.getLogger(FileUploadService.class);

//    private final Path root = Paths.get(Constant.UPLOAD_FOLDER);
    private final Path root = Paths.get("");

    public FileMngDto uploadFile(MultipartFile file, String folderName) throws IOException {
        FileMngDto fileMngDto = new FileMngDto();
        String originalName = file.getOriginalFilename();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        String uploadDirectory = Constant.UPLOAD_FOLDER + '/' + folderName + '/' + dateFormat.format(currentDate);
        String uploadDirectory = '/' + folderName + '/' + dateFormat.format(currentDate);

        String fileName;
        Path filePath = Paths.get(uploadDirectory);
        if (!Files.exists(filePath)) {
            Files.createDirectories(filePath);
        }

        if (Files.exists(Paths.get(uploadDirectory, originalName))) {
            fileName = System.currentTimeMillis() + "_" + originalName;
        } else {

            fileName = originalName;
        }

        String[] fileExt = fileName.split("\\.");
        Path filePathSave = filePath.resolve(fileName);
        Files.copy(file.getInputStream(), filePathSave);

        fileMngDto.setFimFileCategory(folderName);
        fileMngDto.setFimFileName(fileName);
        fileMngDto.setDeleteFlag(Constants.STATE_N);
        fileMngDto.setFimFileSize(file.getSize());
        fileMngDto.setFimFileExt(fileExt[fileExt.length - 1]);
        fileMngDto.setFimFilePath(uploadDirectory);

        return fileMngDto;
    }

    public Resource downloadFile(String fileName, String uploadDirectory) throws IOException {
        Path filePath = Paths.get(uploadDirectory);
        Path file = filePath.resolve(fileName);

        Resource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            log.error("Could not read the file!");
            throw new RuntimeException("Could not read the file!");
        }
    }
}
