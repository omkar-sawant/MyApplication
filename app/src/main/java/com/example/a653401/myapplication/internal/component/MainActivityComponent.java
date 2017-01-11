package com.example.a653401.myapplication.internal.component;

import com.example.a653401.myapplication.internal.PerActivity;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.internal.module.MainActivityModule;
import com.example.a653401.myapplication.view.activity.MainActivity;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import dagger.Component;

/**
 * Created by A653401 on 10-01-2017.
 */
@PerActivity
@Component(dependencies = AndroidApplicationComponent.class,modules = {ActivityModule.class, MainActivityModule.class})
public interface MainActivityComponent extends ActivityComponent{

   // void inject(MainActivity mainActivity);
}
