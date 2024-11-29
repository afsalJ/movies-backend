package com.afsal.MovieApi.controller;

import com.afsal.MovieApi.dto.MovieDto;
import com.afsal.MovieApi.entity.Movie;
import com.afsal.MovieApi.exception.ResourceNotFoundException;
import com.afsal.MovieApi.exception.ValidationException;
import com.afsal.MovieApi.service.MovieService;
import com.afsal.MovieApi.utility.MovieMapper;
import com.afsal.MovieApi.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieService service;


    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = service.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<Movie>> getByName(@PathVariable String name){
        List<Movie> movie = service.getByName(name);
        if(movie != null){
            return new ResponseEntity<>(movie, HttpStatus.FOUND);
        }
        throw new ResourceNotFoundException("movie with name "+name+", not found!");
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer id){
        Movie movie = service.deleteMovie(id);
        if(movie != null){
            return new ResponseEntity<>(movie, HttpStatus.FOUND);
        }
        throw new ResourceNotFoundException("movie with id "+id+", not found!");
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDto movieDto){
        String errorMessage = Validator.validate(movieDto);
        if(errorMessage.isEmpty()){
            Movie movie = MovieMapper.toEntity(movieDto);
            return new ResponseEntity<>(service.addMovie(movie), HttpStatus.OK);
        }
        throw new ValidationException(errorMessage);
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id,@RequestBody MovieDto movieDto){
        if(service.getById(id)!=null){
            String errorMessage = Validator.validate(movieDto);
            if(errorMessage.isEmpty()){
                Movie movie = MovieMapper.toEntity(movieDto);
                movie.setId(id);
                return new ResponseEntity<>(service.addMovie(movie), HttpStatus.OK);
            }
            throw new ValidationException(errorMessage);
        }
        throw new ResourceNotFoundException("movie with id "+id+", not found!");
    }
}
