package com.example.a653401.myapplication.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a653401.myapplication.AndroidAppApplication;
import com.example.a653401.myapplication.R;
import com.example.a653401.myapplication.internal.HasComponents;
import com.example.a653401.myapplication.internal.component.DaggerFragmentComponent;
import com.example.a653401.myapplication.internal.component.DaggerMovieListFragmentComponent;
import com.example.a653401.myapplication.internal.component.MovieListFragmentComponent;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.internal.module.MainActivityModule;
import com.example.a653401.myapplication.internal.module.MovieListFragmentModule;
import com.example.a653401.myapplication.model.MovieModel;
import com.example.a653401.myapplication.presenter.MoviesListFragmentPresenter;
import com.example.a653401.myapplication.presenter.Presenter;
import com.example.a653401.myapplication.view.FragmentNavigationInterface;
import com.example.a653401.myapplication.view.activity.RootActivity;
import com.example.a653401.myapplication.view.adapter.BaseRecyclerViewAdapter;
import com.example.a653401.myapplication.view.adapter.MovieListAdapter;
import com.example.a653401.myapplication.view.adapter.divider.RecyclerViewDivider;
import com.example.myapplication.AndroidApplication;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by A653401 on 06-01-2017.
 */

public class MoviesListFragment extends RootFragment implements BaseRecyclerViewAdapter.ListItemClickListener,
MoviesListFragmentPresenter.MovieListPublish,HasComponents<MovieListFragmentComponent>{

    @Bind(R.id.mainRecyclerView)
    RecyclerView recyclerView;


    @Inject
    MoviesListFragmentPresenter moviesListFragmentPresenter;

    private MovieListFragmentComponent movieListFragmentComponent;


    private MovieListAdapter movieListAdapter;

    FragmentNavigationInterface navigationInterface;

    public MoviesListFragment(){

    }
    public static MoviesListFragment newInstance() {
        MoviesListFragment fragment = new MoviesListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_root;
    }

    /*/
    Since this method will get called in OnActivityCreated() of fragment lifecycle,
    we will actually do all set-up here.
     */
    @Override
    protected void initilizeFragment(Bundle savedInstanceState) {
        initializeInjector();
        navigationInterface = (FragmentNavigationInterface)getActivity();

        movieListAdapter = new MovieListAdapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieListAdapter);
        RecyclerViewDivider dividerItemDecoration = new RecyclerViewDivider(getContext(), R.drawable.line_divider);
        recyclerView.addItemDecoration(dividerItemDecoration);

        movieListAdapter.setListener(this);

        moviesListFragmentPresenter.setView(this);

        showProgressBar();
        moviesListFragmentPresenter.getMovieList();
    }

    @Override
    protected Presenter getPresenter() {
        return moviesListFragmentPresenter;
    }

    @Override
    public void OnRecyclerViewItemClick(RecyclerView recycleView, View view, int adapterPosition) {
        MovieModel selectedMovie = movieListAdapter.getSelectedMovie(adapterPosition);
        moviesListFragmentPresenter.gotoMovieDetailScreen(selectedMovie);
    }

    @Override
    public void publishProgress(List<MovieModel> movieList) {

        movieListAdapter.addItemsList(movieList);
        dismissProgressBar();
    }

    @Override
    public void gotoMovieDetailScreenNavigation(MovieModel movieModel) {
        navigationInterface.navigateFragmenttoFragment(movieModel,MovieDetailFragment.class.getSimpleName());
    }
    private void initializeInjector() {

        this.movieListFragmentComponent = DaggerMovieListFragmentComponent.builder()
                .androidApplicationComponent(((AndroidAppApplication) getActivity().getApplication()).getApplicationComponent())
                .fragmentModule(getFragmentModule())
                .movieListFragmentModule(new MovieListFragmentModule())
                .build();

        this.movieListFragmentComponent.inject(this);

    }

    @Override
    public MovieListFragmentComponent getComponent() {
        return movieListFragmentComponent;
    }
}
