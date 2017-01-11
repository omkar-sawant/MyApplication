package com.example.domain.create_movie_use_case.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * Created by A653401 on 02-01-2017.
 * Represents a Movie from a response.
 */
@Data
public class Movie {

    private String poster_path;

    private boolean adult;

    private String overview;

    private String release_date;

    private List<Integer> genre_ids;

    private int id;

    private String original_title;

    private String title;

    private String original_language;

    private int page;
}
