package com.example.project.crashcourse.movieAPI.Service.Impl;

import com.example.project.crashcourse.movieAPI.Dto.MoviesDto;
import com.example.project.crashcourse.movieAPI.Entity.Movie;
import com.example.project.crashcourse.movieAPI.Repository.MovieRepository;
import com.example.project.crashcourse.movieAPI.Service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ModelMapper mod_map;

    @Value("$(base.url)")
    public String base_url;

    @Override
    public MoviesDto add_movie(MultipartFile file, MoviesDto moviesDto) {

        String fileName = file.getOriginalFilename();

        Movie movie_toSave = new Movie(moviesDto.getMovieId(),moviesDto.getTitle(),moviesDto.getDirector(),moviesDto.getStudio(),moviesDto.getMovieCast(),moviesDto.getReleaseYear(),fileName,moviesDto.getPoster_url());

        Movie savedMovie = movieRepository.save(movie_toSave);

        String url_for_res = base_url + "/" + fileName;

        MoviesDto movieDto = mod_map.map(savedMovie,MoviesDto.class);

        movieDto.setPoster_url(url_for_res);

        return movieDto;
    }
}
