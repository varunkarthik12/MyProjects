package com.example.project.crashcourse.movieAPI.Controller;


import com.example.project.crashcourse.movieAPI.Service.FileSevice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    public FileSevice fileSevice;

    @Value("${project.poster}")
    String path;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadfile (@RequestPart MultipartFile file) throws IOException {

        System.out.println("the path for storing: "+path);
        if (file == null || file.isEmpty()) {
            return new ResponseEntity<>("File is missing", HttpStatus.BAD_REQUEST);
        }
        String fileName = fileSevice.uploadFile(path,file);
        return new ResponseEntity<>("File Uploaded :"+ fileName, HttpStatus.OK);

    }


    @GetMapping("/{fileName}")
    public void getResourceFile (@PathVariable String fileName, HttpServletResponse response) throws IOException {

        InputStream file_as_Inputstream = fileSevice.getResourceFile(path,fileName);

        response.setContentType(MediaType.IMAGE_PNG_VALUE);

        StreamUtils.copy(file_as_Inputstream,response.getOutputStream());

    }
}
