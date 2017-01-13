package com.example.a653401.myapplication.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.a653401.myapplication.AndroidAppApplication;
import com.example.a653401.myapplication.internal.component.ActivityComponent;

import com.example.a653401.myapplication.internal.component.DaggerActivityComponent;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.presenter.Presenter;
import com.example.a653401.myapplication.view.IView;
import com.example.myapplication.AndroidApplication;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import butterknife.ButterKnife;

/**
 * Created by A653401 on 06-01-2017.
 */

public abstract class RootActivity extends AppCompatActivity implements IView{

    private ActivityComponent activityComponent;

    public abstract int getLayoutResourceId();

    public abstract Presenter getPresenter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .androidApplicationComponent(getApplicationComponent())
                    .build();

        }
//        injectActivity(getApplicationComponent());
        int resourceId = getLayoutResourceId();
        if(resourceId > 0) {
            setContentView(resourceId);
            ButterKnife.bind(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.destroy();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment).addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    protected AndroidApplicationComponent getApplicationComponent() {
        return ((AndroidAppApplication) getApplication()).getApplicationComponent();
    }
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

//    public abstract void injectActivity(AndroidApplicationComponent component);

    protected ActivityComponent getActivityComponent(){return activityComponent;}
}
