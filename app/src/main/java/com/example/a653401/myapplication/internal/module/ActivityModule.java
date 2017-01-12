package com.example.a653401.myapplication.internal.module;

import android.app.Activity;

import com.example.a653401.myapplication.internal.PerActivity;
import com.example.a653401.myapplication.internal.PerFragment;
import com.example.domain.create_movie_use_case.interactor.GetMoviesListUseCase;
import com.example.domain.create_movie_use_case.repository.MoviesRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by A653401 on 10-01-2017.
 */
@Module
public class ActivityModule {
    private final Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    @Named("getMoviesListUseCase")
    GetMoviesListUseCase provideGetMoviesListUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MoviesRepository repository){
        return new GetMoviesListUseCase(threadExecutor,postExecutionThread,repository);
    }
}
