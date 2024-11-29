package com.afsal.MovieApi.utility;

import com.afsal.MovieApi.dto.MovieDto;
import com.afsal.MovieApi.entity.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieDto movieDto){
        Movie movie = new Movie(
                movieDto.getName(),
                movieDto.getGenre(),
                movieDto.getRating(),
                movieDto.getDuration(),
                movieDto.getYear()
        );
        return movie;
    }

    public static MovieDto toDto(Movie movie){
        return new MovieDto(
                movie.getName(),
                movie.getGenre(),
                movie.getRating(),
                movie.getDuration(),
                movie.getYear()
        );
    }
}
