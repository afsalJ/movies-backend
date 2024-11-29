package com.afsal.MovieApi.validation;

import com.afsal.MovieApi.dto.MovieDto;

public class Validator {

    public static String validate(MovieDto movieDto){
        if(movieDto.getName().trim().isEmpty()){
            return "Name must not be empty!\n";
        }

        if(movieDto.getGenre().trim().isEmpty()){
            return "Genre must not be empty!\n";
        }

        if (movieDto.getRating() <1 || movieDto.getRating()>5){
            return "Rating must be between 1 and 5\n";
        }

        if (!movieDto.getDuration().matches("\\d+hrs\\s?\\d+mins") && !movieDto.getDuration().matches("\\d+hrs")){
            return "Duration format:()hrs ()mins or ()hrs\n";
        }

        return "";
    }
}
