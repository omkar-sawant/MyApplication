package com.example.myapplication.create_movies.Entity.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;


/**
 * Created by A653401 on 02-01-2017.
 * A Data object of a MovieDTO Item from MoviesDTO.
 */
@Data
public class MovieDTO {

    @Expose
    @SerializedName("poster_path")
    private String poster_path;

    @Expose
    @SerializedName("adult")
    private boolean adult;

    @Expose
    @SerializedName("overview")
    private String overview;

    @Expose
    @SerializedName("release_date")
    private String release_date;

    @Expose
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("original_title")
    private String original_title;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("original_language")
    private String original_language;

}
