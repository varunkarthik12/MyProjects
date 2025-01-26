package com.example.project.crashcourse.movieAPI.Dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDto {


        private Long movieId;


        //@NotBlank(message = "please provide movie's title")
        private String title;


        //@NotBlank(message = "please provide director name")
        private String director;


        // @NotBlank(message = "please provide the studio name")
        private String studio;


        private Set<String> movieCast;

        //@Column(nullable = false)
        private Integer releaseYear;


        //@NotBlank(message = "please provide the movie's title")
        private String  poster;

        private String poster_url;


}

