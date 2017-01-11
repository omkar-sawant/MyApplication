package com.example.a653401.myapplication.internal.component;

import android.app.Activity;

import com.example.a653401.myapplication.internal.PerActivity;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.view.activity.RootActivity;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import dagger.Component;

/**
 * Created by A653401 on 10-01-2017.
 */
@PerActivity
@Component(dependencies = AndroidApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(RootActivity rootactivity);
    Activity activity();
}
