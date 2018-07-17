package com.example.sbjt.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @auth: Created by zk on 2018/7/13
 * @description: 文件处理
 */
@Service
public class FileService {

    private final String uploadPath = "C:\\zk_data\\uploads\\icon\\";

    /**
     * 上传文件
     * @param file
     * @return
     */
    public String upload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        Path path = Paths.get(uploadPath, filename);
        Files.write(path,file.getBytes());
        return path.toString();
    }
}
