package com.example.project.crashcourse.movieAPI.Service;

import com.example.project.crashcourse.movieAPI.Dto.MoviesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService {

    public MoviesDto add_movie(MultipartFile file, MoviesDto moviesDto);
}
