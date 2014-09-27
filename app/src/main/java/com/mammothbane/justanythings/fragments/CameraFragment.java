package com.mammothbane.justanythings.fragments;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.commonsware.cwac.camera.CameraView;
import com.mammothbane.justanythings.R;
import com.mammothbane.justanythings.views.CameraPreview;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class CameraFragment extends Fragment {

    @InjectView(R.id.fl_camera) FrameLayout frameLayout;

    Camera camera;

    CameraView cameraView;

    @Override
    public void onResume() {
        super.onResume();
        camera = getCamera();
        cameraView = new CameraView(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, view);

        frameLayout.addView(new CameraPreview(getActivity(), camera));

        return view;
    }

    @Nullable
    static Camera getCamera() {
        Camera c = null;
        try {
            Camera.open();
        } catch (Exception ignore) {}
        return c;
    }
}
