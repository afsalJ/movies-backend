package com.afsal.MovieApi.service;

import com.afsal.MovieApi.dao.MovieDao;
import com.afsal.MovieApi.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDao dao;

    public List<Movie> getAllMovies(){
        return dao.findAll();
    }

    public List<Movie> getByName(String name){
        return dao.findAllByName(name);
    }

    public Movie getById(Integer id){
        return dao.findById(id).orElse(null);
    }

    public Movie addMovie(Movie movie){
        return dao.save(movie);
    }

    public Movie deleteMovie(Integer id){
        Movie movie = getById(id);
        if(movie!=null)dao.delete(movie);
        return movie;
    }
}
