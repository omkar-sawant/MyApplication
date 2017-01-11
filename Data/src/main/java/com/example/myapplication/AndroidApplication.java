package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.internal.di.component.AndroidApplicationComponent;
import com.example.myapplication.internal.di.component.DaggerAndroidApplicationComponent;
import com.example.myapplication.internal.di.module.AndroidApplicationModule;


/**
 * Created by A653401 on 04-01-2017.
 */

public class AndroidApplication extends Application {

    private AndroidApplicationComponent androidAppComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.androidAppComponent.inject(this);
    }
    private void initializeInjector() {

       this.androidAppComponent = DaggerAndroidApplicationComponent.builder().
               androidApplicationModule(new AndroidApplicationModule(this))
                .build();
    }

    public AndroidApplicationComponent getApplicationComponent() {
        return this.androidAppComponent;
    }
}
