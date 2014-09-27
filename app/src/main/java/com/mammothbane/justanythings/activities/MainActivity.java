package com.mammothbane.justanythings.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.commonsware.cwac.camera.CameraFragment;
import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.SimpleCameraHost;
import com.mammothbane.justanythings.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class MainActivity extends Activity {

    CameraFragment cameraFragment;
    CameraHost cameraHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        cameraFragment = (CameraFragment)getFragmentManager().findFragmentByTag("frag_camera");
        cameraHost = new SimpleCameraHost.Builder(this).useFrontFacingCamera(false).photoDirectory(getCacheDir()).useFullBleedPreview(true).build();
        cameraFragment.setHost(cameraHost);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }


    @OnClick(R.id.ib_choose)
    public void choosePhoto(View view) {
        Intent intent = new Intent();

    }

    @OnClick(R.id.ib_take)
    public void takePhoto(View view) {


    }

}
