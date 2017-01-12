package com.example.a653401.myapplication.internal.component;

import android.app.Activity;

import com.example.a653401.myapplication.AndroidAppApplication;
import com.example.a653401.myapplication.internal.PerActivity;
import com.example.a653401.myapplication.internal.PerFragment;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.view.activity.MainActivity;
import com.example.a653401.myapplication.view.activity.RootActivity;
import com.example.a653401.myapplication.view.fragment.MoviesListFragment;
import com.example.a653401.myapplication.view.fragment.RootFragment;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import dagger.Component;
import dagger.Provides;

/**
 * Created by A653401 on 10-01-2017.
 */
@PerActivity
@Component(dependencies = AndroidApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
    void inject(MainActivity mainActivity);
    void inject (RootFragment rootFragment);
    void inject (MoviesListFragment moviesListFragment);
}
