package com.afsal.MovieApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String name;
    private String genre;
    private Double rating;
    private String duration;
    private Integer year;
}
