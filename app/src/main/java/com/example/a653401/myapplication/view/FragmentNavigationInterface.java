package com.example.a653401.myapplication.view;

import android.os.Parcelable;

/**
 * Created by A653401 on 09-01-2017.
 *To perform Fragment to Fragment transaction.
 */

public interface FragmentNavigationInterface {

     void navigateFragmenttoFragment(Parcelable dataObject, String fragmentName);
}
