package com.example.myapplication.create_movies.Repository;

import com.example.myapplication.create_movies.Entity.dto.MovieDTO;
import com.example.myapplication.create_movies.Entity.dto.MoviesDTO;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by A653401 on 03-01-2017.
 */

public interface ServiceApiMovies {


    @GET("movie/{movie_id}")
    Observable<MovieDTO> getMovie(@Path("movie_id") int id);

    @GET("movie")
    Observable<MoviesDTO> getMovies(@Query("api_key") String apikey,@Query("language") String language,@Query("page") int page);
}
