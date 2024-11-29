package com.afsal.MovieApi.dao;

import com.afsal.MovieApi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    public List<Movie> findAllByName(String name);
}
