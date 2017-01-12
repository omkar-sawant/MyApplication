package com.example.a653401.myapplication.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.a653401.myapplication.AndroidAppApplication;
import com.example.a653401.myapplication.R;
import com.example.a653401.myapplication.internal.component.ActivityComponent;
import com.example.a653401.myapplication.internal.component.DaggerActivityComponent;
import com.example.a653401.myapplication.internal.module.ActivityModule;
import com.example.a653401.myapplication.presenter.Presenter;
import com.example.a653401.myapplication.view.IView;
import com.example.a653401.myapplication.view.activity.MainActivity;
import com.example.myapplication.internal.di.component.AndroidApplicationComponent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by A653401 on 06-01-2017.
 */

public abstract class RootFragment extends Fragment implements IView {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    private ActivityComponent activityComponent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutResourceId(), container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    protected abstract int getLayoutResourceId();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/*        if (fragmentComponent == null) {
            fragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(getFragmentModule())
                    .androidApplicationComponent(((AndroidAppApplication) getActivity().getApplication()).getApplicationComponent())
                    .build();
            fragmentComponent.inject(this);

        }*/
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(getActivity()))
                    .androidApplicationComponent(getApplicationComponent())
                    .build();
            activityComponent.inject(this);

        }

        initilizeFragment(savedInstanceState);
    }
    protected AndroidApplicationComponent getApplicationComponent() {
        return ((AndroidAppApplication) (getActivity().getApplication())).getApplicationComponent();
    }
    protected ActivityComponent getActivityComponent(){return activityComponent;}

    protected abstract void initilizeFragment(Bundle savedInstanceState);

    protected abstract Presenter getPresenter();


    @Override
    public void onResume() {
        super.onResume();
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.pause();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        Presenter presenter = getPresenter();
        if(presenter != null)
            presenter.destroy();
    }

    protected void showProgressBar()
    {
    if(progressBar != null)
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void dismissProgressBar()
    {
        if(progressBar != null)
            progressBar.setVisibility(View.GONE);
    }

}
