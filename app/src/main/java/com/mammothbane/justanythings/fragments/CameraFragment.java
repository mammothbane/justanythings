package com.mammothbane.justanythings.fragments;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mammothbane.justanythings.R;
import com.mammothbane.justanythings.views.CameraPreview;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class CameraFragment extends Fragment {

    @InjectView(R.id.fl_camera) FrameLayout frameLayout;
    @InjectView(R.id.tv_cam_err) TextView tvError;

    @Inject
    Provider<Camera> cameraProvider;

    Camera camera;

    @Override
    public void onStart() {
        super.onStart();
        //App app = App.get();
        //App.get().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        hideCameraError();
        camera = cameraProvider.get();
        if (camera != null) {
            frameLayout.addView(new CameraPreview(getActivity(), camera));
        } else {
            showCameraError();
            frameLayout.removeAllViews();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_camera, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    public void showCameraError() {
        tvError.setVisibility(View.VISIBLE);
    }

    public void hideCameraError() {
        tvError.setVisibility(View.GONE);
    }

}
