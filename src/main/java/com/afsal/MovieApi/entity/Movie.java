package com.afsal.MovieApi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private String duration;

    @Column(name = "release_year", nullable = false)
    private Integer year;

    public Movie(String name, String genre, Double rating, String duration, Integer year) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.year = year;
    }
}
