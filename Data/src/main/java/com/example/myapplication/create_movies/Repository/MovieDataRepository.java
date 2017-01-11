package com.example.myapplication.create_movies.Repository;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.domain.create_movie_use_case.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;


/**
 * Created by A653401 on 03-01-2017.
 */

public class MovieDataRepository implements MoviesRepository{


    private final MovieDataStoreFactory dataStoreFactory;

    @Inject
    public MovieDataRepository(MovieDataStoreFactory dataStoreFactory) {
        if (dataStoreFactory == null) {
            throw new IllegalArgumentException("Parameters can't be null.");
        }
        this.dataStoreFactory = dataStoreFactory;
    }

    @Override
    public Observable<List<Movie>> getMovies(String apikey,String language,int page) {
        return dataStoreFactory.create().getMovies(apikey,language,page);
    }

    @Override
    public Observable<Movie> getMovie(Movie movie) {
        return dataStoreFactory.create().getMovie(movie.getId());
    }
}
