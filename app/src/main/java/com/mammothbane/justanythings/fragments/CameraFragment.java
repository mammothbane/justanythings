package com.mammothbane.justanythings.fragments;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mammothbane.justanythings.App;
import com.mammothbane.justanythings.R;
import com.mammothbane.justanythings.activities.MainActivity;
import com.mammothbane.justanythings.views.CameraPreview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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
    @InjectView(R.id.bt_photo) Button btPhoto;

    @Inject
    Provider<Camera> cameraProvider;

    Camera camera;

    @Override
    public void onStart() {
        super.onStart();
        App.inject(this);
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

    void captureImage() {
        if (camera == null) throw new NullPointerException("camera was null.");
        final Date now = new Date();

        camera.takePicture(null, null, new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] bytes, Camera camera) {
                try {
                    FileOutputStream fos = new FileOutputStream(getOutputMediaFile());
                    fos.write(bytes);
                    fos.close();
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
                Log.d(getClass().getSimpleName(), "image taken. delay " + ((new Date().getTime() - now.getTime())) + "ms.");
                camera.startPreview();
            }
        });

        ((MainActivity) getActivity()).waitForImage();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_camera, container, false);
        ButterKnife.inject(this, view);
        btPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
            }
        });
        return view;
    }

    public void showCameraError() {
        tvError.setVisibility(View.VISIBLE);
    }

    public void hideCameraError() {
        tvError.setVisibility(View.GONE);
    }

    private File getOutputMediaFile() {
        return new File(getActivity().getCacheDir().getPath() + File.separator + "img" + UUID.randomUUID() + ".jpg");
    }

}
