package com.example.a653401.myapplication.view.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.a653401.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by A653401 on 06-01-2017.
 */

public class MovieListViewHolder extends BaseViewHolder {

    public MovieListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    @Bind(R.id.movieTitleTextview)
    public TextView movieTitle;

    @Bind(R.id.movieLanguageTextview)
    public TextView movieLanguage;

    @Bind(R.id.movieReleaseDateTextview)
    public TextView movieReleaseDate;
}
