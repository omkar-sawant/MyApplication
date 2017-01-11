package com.example.myapplication.create_movies.Entity.dto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;


/**
 * Created by A653401 on 30-12-2016.
 * This class is representation of Data Transfer Object from Server api for a list of Movies
 */
@Data
public class MoviesDTO {

    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("total_results")
    private int total_results;

    @Expose
    @SerializedName("total_pages")
    private int total_pages;

    @Expose
    @SerializedName("results")
    private List<MovieDTO> results;

}
