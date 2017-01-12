package com.example.a653401.myapplication.presenter;

import com.example.a653401.myapplication.internal.PerActivity;
import com.example.a653401.myapplication.internal.PerFragment;
import com.example.a653401.myapplication.model.MovieModel;
import com.example.a653401.myapplication.model.mapper.MovieModelMapper;
import com.example.a653401.myapplication.view.fragment.MoviesListFragment;
import com.example.domain.create_movie_use_case.interactor.GetMoviesListUseCase;
import com.example.domain.create_movie_use_case.model.Movie;
import com.example.domain.subscriber.DefaultSubscriber;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by A653401 on 06-01-2017.
 */
public class MoviesListFragmentPresenter extends Presenter<MoviesListFragment> {

    private GetMoviesListUseCase moviesListUseCase;

    /**
     * With below injection, a method 'getMoviesListUseCase' gets called of a dagger which returns a object
     * of GetMoviesListUseCase.
     * @param moviesListUseCase
     */
    @Inject
    public MoviesListFragmentPresenter(@Named("getMoviesListUseCase")GetMoviesListUseCase moviesListUseCase)
    {
        this.moviesListUseCase = moviesListUseCase;
    }
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    /*
    Below interface is used so Presenter will be able to call Views methods, as we are implementing this interface with our fragment.
     */
    public interface MovieListPublish {
        void publishProgress(List<MovieModel> movieList);
        void gotoMovieDetailScreenNavigation(MovieModel movieModel);

    }

    public void getMovieList()
    {
        if(checkInternetConnection())
            moviesListUseCase.execute("2902d1d94bda1ae98d56a0a67b8ca644","en-US",1,new getMoviesSubscriber());
    }

    public void gotoMovieDetailScreen(MovieModel movieModel)
    {
        view.gotoMovieDetailScreenNavigation(movieModel);
    }

    private final class getMoviesSubscriber extends DefaultSubscriber<List<Movie>>
    {
        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(List<Movie> movies) {
            List<MovieModel> movieList = new MovieModelMapper().dataListToModelList(movies);
            view.publishProgress(movieList);
        }
    }
}
