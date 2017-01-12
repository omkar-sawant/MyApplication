package com.example.a653401.myapplication.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.a653401.myapplication.internal.PerFragment;
import com.example.a653401.myapplication.view.fragment.MovieDetailFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.inject.Inject;

import static android.R.attr.bitmap;

/**
 * Created by A653401 on 09-01-2017.
 */

public class MovieDetailFragmentPresenter extends Presenter<MovieDetailFragment> {

    @Inject
    public MovieDetailFragmentPresenter(){

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
    With this interface we will call setMoviePoster() of a view from presenter.
     */
    public interface MovieDetailsFragmentInterface{
         void setMoviePoster(Bitmap bmp);
    }

    /**
     * This method will get bitmap from path. And a Views method will get called to set bitmap in imageview.
     * @param path - MoviesPosterPath
     */
    public void getBitmapFromPath(String path){
        try {
            java.net.URL url = new java.net.URL(path);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            view.setMoviePoster(myBitmap);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
