package com.example.a653401.myapplication.internal.module;

import android.support.v4.app.Fragment;

import com.example.a653401.myapplication.internal.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by A653401 on 10-01-2017.
 */
@Module
public class FragmentModule {
    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment fragment()
    {
        return this.fragment;
    }
}
