package com.example.a653401.myapplication.view.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a653401.myapplication.R;
import com.example.a653401.myapplication.model.MovieModel;
import com.example.a653401.myapplication.presenter.MovieDetailFragmentPresenter;
import com.example.a653401.myapplication.presenter.Presenter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by A653401 on 09-01-2017.
 */

public class MovieDetailFragment extends RootFragment implements MovieDetailFragmentPresenter.MovieDetailsFragmentInterface{

    @Bind(R.id.movieTitleText)
     TextView movieTitle;
    @Bind(R.id.movieOriginalTitleText)
     TextView movieOriginalTitleText;
    @Bind(R.id.movieOriginalLanguageText)
     TextView movieOriginalLanguageText;
    @Bind(R.id.movieReleaseDateText)
     TextView movieReleaseDateText;
    @Bind(R.id.movieOverviewText)
     TextView movieOverviewText;
    @Bind(R.id.moviePosterImage)
     ImageView moviePoster;

    public static MovieDetailFragment newInstance(MovieModel movieModel) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle argumentsBundle = new Bundle();
        argumentsBundle.putParcelable("MOVIE_DATA", movieModel);
        fragment.setArguments(argumentsBundle);
        return fragment;
    }

    @Inject
    MovieDetailFragmentPresenter movieDetailFragmentPresenter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.movie_detail;
    }

    @Override
    protected void initilizeFragment(Bundle savedInstanceState) {
        getActivityComponent().inject(this);
        MovieModel movieData = getArguments().getParcelable("MOVIE_DATA");
        if(movieData != null){
            movieTitle.setText(movieData.getTitle());
            movieOriginalTitleText.setText(movieData.getOriginal_title());
            movieOriginalLanguageText.setText(movieData.getOriginal_language());
            movieReleaseDateText.setText(movieData.getRelease_date());
            movieOverviewText.setText(movieData.getOverview());

        }
        movieDetailFragmentPresenter.setView(this);
        movieDetailFragmentPresenter.getBitmapFromPath(movieData.getPoster_path());

    }

    @Override
    protected Presenter getPresenter() {
        return movieDetailFragmentPresenter;
    }

    @Override
    public void setMoviePoster(Bitmap bmp) {
        if(bmp != null)
            moviePoster.setImageBitmap(bmp);
    }
}
