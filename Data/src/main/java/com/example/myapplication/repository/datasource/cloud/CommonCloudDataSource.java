package com.example.myapplication.repository.datasource.cloud;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by A653401 on 03-01-2017.
 */

public abstract class CommonCloudDataSource {
    /**
     * Build the Retrofit object for the REST services.
     */
    protected Retrofit buildRetrofit() {
        OkHttpClient httpClient = new OkHttpClient();
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/discover")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
