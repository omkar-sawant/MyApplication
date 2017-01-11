package com.example.a653401.myapplication.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.a653401.myapplication.R;
import com.example.a653401.myapplication.model.MovieModel;
import com.example.a653401.myapplication.view.adapter.viewholder.BaseViewHolder;
import com.example.a653401.myapplication.view.adapter.viewholder.MovieListViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A653401 on 06-01-2017.
 */

public class MovieListAdapter extends BaseRecyclerViewAdapter implements BaseViewHolder.OnViewHolderClickedListener{

    private List<Object> items;
    public MovieListAdapter(){
        items = new ArrayList<>();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder baseHolder;
        baseHolder = new MovieListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false));
        baseHolder.setListener(this);
        return baseHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MovieListViewHolder movieHolder = (MovieListViewHolder)holder;
        final MovieModel item = (MovieModel) items.get(position);
        movieHolder.movieTitle.setText(item.getTitle());
        movieHolder.movieLanguage.setText(item.getOriginal_language());
        movieHolder.movieReleaseDate.setText(item.getRelease_date());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItemsList(List<MovieModel> list){
        int itemRangeStart = items.size();
        items.addAll(list);
        notifyItemRangeInserted(itemRangeStart,list.size());

    }

    public MovieModel getSelectedMovie(int position)
    {
        MovieModel selectedMovie;
        try {
            selectedMovie = (MovieModel)items.get(position);
        }catch (Exception e){
            selectedMovie = null;
        }
        return selectedMovie;
    }
}
