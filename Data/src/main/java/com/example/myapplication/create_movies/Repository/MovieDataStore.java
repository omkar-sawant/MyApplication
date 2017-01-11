package com.example.myapplication.create_movies.Repository;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.myapplication.create_movies.Entity.dto.MovieDTO;
import com.example.myapplication.create_movies.Entity.dto.MoviesDTO;

import java.util.List;

import rx.Observable;


/**
 * Created by A653401 on 03-01-2017.
 */

public interface MovieDataStore {

    Observable<List<Movie>> getMovies(String apikey,String language,int page);
    Observable<Movie> getMovie(int id);
}
