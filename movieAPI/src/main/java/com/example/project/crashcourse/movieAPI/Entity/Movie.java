package com.example.project.crashcourse.movieAPI.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column
    //@NotBlank(message = "please provide movie's title")
    private String title;

    @Column
    //@NotBlank(message = "please provide director name")
    private String director;

    @Column
   // @NotBlank(message = "please provide the studio name")
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;

    //@Column(nullable = false)
    private Integer releaseYear;

    @Column
    //@NotBlank(message = "please provide the movie's title")
    private String  poster;

    private String poster_url;


}
