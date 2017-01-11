package com.example.domain.create_movie_use_case.interactor;

import com.example.domain.create_movie_use_case.model.Movie;
import com.example.domain.create_movie_use_case.repository.MoviesRepository;
import com.example.domain.executor.PostExecutionThread;
import com.example.domain.executor.ThreadExecutor;
import com.example.domain.interactor.Interactor;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by A653401 on 05-01-2017.
 */

public class GetMoviesListUseCase extends Interactor {

    private final MoviesRepository repository;
    private int page;
    private String language,apikey;

    @Inject
    public GetMoviesListUseCase(ThreadExecutor threadExecutor,PostExecutionThread postExecutionThread,MoviesRepository repository)
    {
        super(threadExecutor,postExecutionThread);
        if (repository == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        this.repository = repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return repository.getMovies(apikey,language,page);
    }

    public void execute(String apikey,String language,int page,Subscriber subscriber)
    {
        this.apikey = apikey;
        this.page = page;
        this.language = language;
        super.execute(subscriber);
    }
}
