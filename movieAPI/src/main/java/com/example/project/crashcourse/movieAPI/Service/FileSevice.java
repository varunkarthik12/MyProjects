package com.example.project.crashcourse.movieAPI.Service;

import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public interface FileSevice {

    public String uploadFile(String path, MultipartFile file) throws IOException;
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException;

}
