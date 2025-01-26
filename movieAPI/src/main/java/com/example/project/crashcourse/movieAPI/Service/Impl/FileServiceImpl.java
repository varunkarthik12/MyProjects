package com.example.project.crashcourse.movieAPI.Service.Impl;

import com.example.project.crashcourse.movieAPI.Service.FileSevice;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileSevice {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        if (path.endsWith(File.separator)) {
            path = path.substring(0, path.length() - 1);
        }

        String fileName = file.getOriginalFilename();

         String filePath = path + "/" + fileName;

        File f = new File(path);
        if(!f.exists())
        {
            f.mkdir();
        }

        System.out.println(Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING));

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {

        String filePath = path + File.separator + fileName;

        return new FileInputStream(filePath);
    }
}
