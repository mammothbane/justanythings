package com.mammothbane.justanythings.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.mammothbane.justanythings.R;
import com.mammothbane.justanythings.views.CameraPreview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class MainActivity extends Activity {

    private Camera mCamera;
    private boolean choosingPhoto = false;
    private CameraPreview cameraPreview;
    @InjectView(R.id.fl_camera) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (hasCamera()) {
            mCamera = getCameraInstance();
            cameraPreview = new CameraPreview(this, mCamera);
            frameLayout.addView(cameraPreview);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (cameraPreview != null && frameLayout.getChildAt(0) == cameraPreview) frameLayout.removeView(cameraPreview);
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    private static Camera getCameraInstance() {
        Camera camera = null;
        try {
            camera = Camera.open();
        } catch (Exception ignore) {}
        return camera;
    }

    @OnClick(R.id.ib_choose)
    public void choosePhoto(View view) {
        choosingPhoto = true;
        Intent intent = new Intent();

    }

    @OnClick(R.id.ib_take)
    public void takePhoto(View view) {


    }

}
