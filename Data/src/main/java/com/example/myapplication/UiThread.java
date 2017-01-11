package com.example.myapplication;

import com.example.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;


import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by A653401 on 04-01-2017.
 */
@Singleton
public class UiThread implements PostExecutionThread {

    @Inject
    public UiThread(){

    }
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
