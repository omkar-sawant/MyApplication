package com.example.a653401.myapplication.internal.module;

import android.app.Activity;

import com.example.a653401.myapplication.internal.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by A653401 on 10-01-2017.
 */
@Module
public class ActivityModule {
    private final Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
