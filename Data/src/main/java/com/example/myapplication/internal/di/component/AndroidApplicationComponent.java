package com.example.myapplication.internal.di.component;

/**
 * Created by A653401 on 04-01-2017.
 */

import android.content.Context;

import com.example.domain.create_movie_use_case.repository.MoviesRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.myapplication.AndroidApplication;
import com.example.myapplication.internal.di.module.AndroidApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.DaggerCollections;

@Singleton
@Component (modules = AndroidApplicationModule.class)
public interface AndroidApplicationComponent {

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    MoviesRepository movieRepository();

    void inject(AndroidApplication androidApplication);
}
