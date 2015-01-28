package com.mammothbane.justanythings.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mammothbane.justanythings.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class MainFragment extends Fragment {
    @InjectView(R.id.bt_select)
    Button selectImage;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main, container, false);
        ButterKnife.inject(view);

//        selectImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectImage();
//            }
//        });

        return view;
    }

    public void selectImage() {
        throw new UnsupportedOperationException();
    }

}
