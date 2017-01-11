package com.example.a653401.myapplication.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.a653401.myapplication.view.IView;

import javax.inject.Inject;

/**
 * Created by A653401 on 06-01-2017.
 */

public abstract class Presenter <V extends IView>{

    protected V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }




    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();

    public boolean checkInternetConnection() {
        NetworkInfo netInfo = null;
        if (view.getContext() != null) {
            ConnectivityManager cm = (ConnectivityManager) view.getContext().
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            netInfo = cm.getActiveNetworkInfo();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
