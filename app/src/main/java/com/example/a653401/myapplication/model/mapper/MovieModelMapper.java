package com.example.a653401.myapplication.model.mapper;

import com.example.a653401.myapplication.model.MovieModel;
import com.example.domain.create_movie_use_case.model.Movie;
import com.example.myapplication.mapper.dto.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A653401 on 06-01-2017.
 */

public class MovieModelMapper implements Mapper<MovieModel,Movie> {
    @Override
    public Movie modelToData(MovieModel model) {
        Movie movieObject = new Movie();
        if(null != model){
            movieObject.setAdult(model.isAdult());
            movieObject.setTitle(model.getTitle());
            movieObject.setOriginal_title(model.getOriginal_title());
            movieObject.setPoster_path(model.getPoster_path());
            movieObject.setGenre_ids(model.getGenre_ids());
            movieObject.setId(model.getId());
            movieObject.setOriginal_language(model.getOriginal_language());
            movieObject.setOverview(model.getOverview());
            movieObject.setPage(model.getPage());
            movieObject.setRelease_date(model.getRelease_date());
        }
        return movieObject;
    }

    @Override
    public MovieModel dataToModel(Movie data) {
        MovieModel movieModel = new MovieModel();
        if(null != data){
            movieModel.setAdult(data.isAdult());
            movieModel.setTitle(data.getTitle());
            movieModel.setOriginal_title(data.getOriginal_title());
            movieModel.setPoster_path(data.getPoster_path());
//            movieModel.setGenre_ids(data.getGenre_ids());
            movieModel.setId(data.getId());
            movieModel.setOriginal_language(data.getOriginal_language());
            movieModel.setOverview(data.getOverview());
            movieModel.setPage(data.getPage());
            movieModel.setRelease_date(data.getRelease_date());
        }
        return movieModel;
    }

    @Override
    public List<MovieModel> dataListToModelList(List<Movie> data) {
        List<MovieModel> model = new ArrayList<>();
        if (null != data){
            for(Movie movie:data){
                model.add(dataToModel(movie));
            }
        }
        return model;
    }

    @Override
    public List<Movie> modelLisToDataList(List<MovieModel> model) {
        List<Movie> data = new ArrayList<>();
        if (null != model){
            for(MovieModel moviemodel:model){
                data.add(modelToData(moviemodel));
            }
        }
        return data;
    }
}
