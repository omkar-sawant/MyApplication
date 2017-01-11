package com.example.myapplication.internal.di.module;

import android.content.Context;

import com.example.domain.create_movie_use_case.repository.MoviesRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.myapplication.AndroidApplication;
import com.example.myapplication.UiThread;
import com.example.myapplication.create_movies.Repository.MovieDataRepository;
import com.example.myapplication.executor.JobExecutor;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by A653401 on 04-01-2017.
 */
@Module
public class AndroidApplicationModule {

    private final AndroidApplication androidApplication;

    public AndroidApplicationModule(AndroidApplication androidApplication)
    {
        this.androidApplication = androidApplication;
    }

    @Provides
    @Singleton
    Context provideAppicationContext(){
        return  androidApplication;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    MoviesRepository provideMoviesRepository(MovieDataRepository movieDataRepository){
        return movieDataRepository;
    }


}
