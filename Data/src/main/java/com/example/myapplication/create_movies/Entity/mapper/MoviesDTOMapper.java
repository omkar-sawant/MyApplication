package com.example.myapplication.create_movies.Entity.mapper;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.myapplication.create_movies.Entity.dto.MoviesDTO;
import com.example.myapplication.mapper.dto.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A653401 on 02-01-2017.
 */

public class MoviesDTOMapper implements Mapper<List<Movie>,MoviesDTO> {
    @Override
    public MoviesDTO modelToData(List<Movie> model) {
        return null;
    }

    @Override
    public List<Movie> dataToModel(MoviesDTO data) {

        List<Movie> model = new ArrayList<>();
        if (data != null) {
           model = new MovieDTOMapper().dataListToModelList(data.getResults());
        }
        return model;
    }

    @Override
    public List<List<Movie>> dataListToModelList(List<MoviesDTO> data) {
        return null;
    }

    @Override
    public List<MoviesDTO> modelLisToDataList(List<List<Movie>> model) {
        return null;
    }
}
