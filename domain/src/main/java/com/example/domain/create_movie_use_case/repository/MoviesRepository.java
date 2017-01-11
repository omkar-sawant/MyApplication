package com.example.domain.create_movie_use_case.repository;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.domain.repository.Repository;

import java.util.List;

import rx.Observable;


/**
 * Created by A653401 on 03-01-2017.
 */

public interface MoviesRepository extends Repository {

    Observable<List<Movie>> getMovies(String apikey,String language,int page);

    Observable<Movie> getMovie(Movie movie);
}
