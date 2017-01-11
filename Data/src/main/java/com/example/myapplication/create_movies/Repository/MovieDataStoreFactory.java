package com.example.myapplication.create_movies.Repository;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by A653401 on 03-01-2017.
 */

public class MovieDataStoreFactory {

    private final Context context;

    @Inject
    public MovieDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        this.context = context.getApplicationContext();
    }


    public MovieDataStore create() {
        return createCloudDataStore();
    }

    public MovieDataStore createCloudDataStore() {
        return new CloudMovieDataStore();
    }

}
