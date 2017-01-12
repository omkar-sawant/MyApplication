package com.example.a653401.myapplication.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.a653401.myapplication.AndroidAppApplication;
import com.example.a653401.myapplication.R;
import com.example.a653401.myapplication.model.MovieModel;
import com.example.a653401.myapplication.presenter.MainActivityPresenter;
import com.example.a653401.myapplication.presenter.Presenter;
import com.example.a653401.myapplication.view.FragmentNavigationInterface;
import com.example.a653401.myapplication.view.fragment.MovieDetailFragment;
import com.example.a653401.myapplication.view.fragment.MoviesListFragment;
import com.example.myapplication.AndroidApplication;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends RootActivity implements FragmentNavigationInterface{



    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public Presenter getPresenter() {
        return mainActivityPresenter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        initializeInjector();
        addFragment(R.id.container_fragment, MoviesListFragment.newInstance());
        mainActivityPresenter.setView(this);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void navigateFragmenttoFragment(Parcelable object, String fragmentName) {
        switch (fragmentName){
            case "MovieDetailFragment":
                addFragment(R.id.container_fragment,MovieDetailFragment.newInstance((MovieModel)object));
                break;
            default:
                break;
        }
    }
   private void initializeInjector() {
/*       this.mainActivityComponent = DaggerMainActivityComponent.builder()
               .androidApplicationComponent((this).getApplicationComponent())
               .activityModule(getActivityModule())
               .build();
       this.mainActivityComponent.inject(this);*/
       getActivityComponent().inject(this);
    }




}
