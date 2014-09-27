package com.mammothbane.justanythings.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mammothbane.justanythings.R;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class TumblrFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_tumblr_connect, container, false);
    }
}
