package com.example.myapplication.create_movies.Repository;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.myapplication.create_movies.Entity.dto.MovieDTO;
import com.example.myapplication.create_movies.Entity.dto.MoviesDTO;
import com.example.myapplication.create_movies.Entity.mapper.MovieDTOMapper;
import com.example.myapplication.create_movies.Entity.mapper.MoviesDTOMapper;
import com.example.myapplication.repository.datasource.cloud.CommonCloudDataSource;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Retrofit;
import rx.Observable;


/**
 * Created by A653401 on 03-01-2017.
 */

public class CloudMovieDataStore extends CommonCloudDataSource implements MovieDataStore{

    private final ServiceApiMovies apiService;

    public CloudMovieDataStore() {
        Retrofit retrofit = buildRetrofit();
        apiService = retrofit.create(ServiceApiMovies.class);
    }

    @Override
    public Observable<List<Movie>> getMovies(String apikey,String language,int page) {

        return apiService.getMovies(apikey, language, page).map(new MoviesDTOMapper()::dataToModel);
    }

    @Override
    public Observable<Movie> getMovie(int id) {
        return apiService.getMovie(id).map(new MovieDTOMapper()::dataToModel);
    }
}
