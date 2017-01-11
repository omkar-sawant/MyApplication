package com.example.myapplication.create_movies.Entity.mapper;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.myapplication.create_movies.Entity.dto.MovieDTO;
import com.example.myapplication.create_movies.Entity.dto.MoviesDTO;
import com.example.myapplication.entity.mapper.BaseMapper;
import com.example.myapplication.mapper.dto.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by A653401 on 03-01-2017.
 */

public class MovieDTOMapper extends BaseMapper implements Mapper<Movie,MovieDTO> {
    @Override
    public MovieDTO modelToData(Movie model) {
        MovieDTO moviedto = new MovieDTO();
        if(null != model){
            moviedto.setAdult(model.isAdult());
            moviedto.setPoster_path(model.getPoster_path());
            moviedto.setOriginal_title(model.getOriginal_title());
            moviedto.setTitle(model.getTitle());
            moviedto.setGenre_ids(model.getGenre_ids());
            moviedto.setOriginal_language(model.getOriginal_language());
            moviedto.setOverview(model.getOverview());
            moviedto.setPoster_path(model.getPoster_path());
            moviedto.setRelease_date(model.getRelease_date());
            moviedto.setId(model.getId());
        }

        return moviedto;
    }

    @Override
    public Movie dataToModel(MovieDTO data) {
        Movie movie = new Movie();
        if(null != data){
            movie.setAdult(data.isAdult());
            movie.setPoster_path(data.getPoster_path());
            movie.setOriginal_title(data.getOriginal_title());
            movie.setTitle(data.getTitle());
            movie.setGenre_ids(data.getGenre_ids());
            movie.setOriginal_language(data.getOriginal_language());
            movie.setOverview(data.getOverview());
            movie.setPoster_path(data.getPoster_path());
            movie.setRelease_date(data.getRelease_date());
            movie.setId(data.getId());
        }
        return movie;
    }

    @Override
    public List<Movie> dataListToModelList(List<MovieDTO> data) {
        List<Movie> movieList = new ArrayList<>();
        if (data != null) {
            for (MovieDTO planetDto : data) {
                movieList.add(dataToModel(planetDto));
            }
        }
        return movieList;
    }

    @Override
    public List<MovieDTO> modelLisToDataList(List<Movie> model) {
        List<MovieDTO> data = new ArrayList<>();
        if (model != null) {
            for (Movie movie : model) {
                data.add(modelToData(movie));
            }
        }
        return data;
    }
}
