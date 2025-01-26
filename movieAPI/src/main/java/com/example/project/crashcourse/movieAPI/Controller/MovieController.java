package com.example.project.crashcourse.movieAPI.Controller;

import com.example.project.crashcourse.movieAPI.Dto.MoviesDto;
import com.example.project.crashcourse.movieAPI.Service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    public MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<MoviesDto> add_movie (@RequestPart  MultipartFile file , @RequestPart String dto) throws JsonProcessingException {
        MoviesDto dto_to_pass = convertStringToJSON(dto);

        MoviesDto response_dto = movieService.add_movie(file,dto_to_pass);

        return new ResponseEntity<>(response_dto, HttpStatus.CREATED);
    }

    public MoviesDto convertStringToJSON (String dto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(dto,MoviesDto.class);
    }

}
