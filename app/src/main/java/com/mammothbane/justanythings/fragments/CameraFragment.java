package com.mammothbane.justanythings.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.SimpleCameraHost;
import com.mammothbane.justanythings.R;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class CameraFragment extends Fragment {

    com.commonsware.cwac.camera.acl.CameraFragment cameraFragment;
    CameraHost cameraHost;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        cameraFragment = new com.commonsware.cwac.camera.acl.CameraFragment();

        //cameraFragment = ((com.commonsware.cwac.camera.acl.CameraFragment) getChildFragmentManager().findFragmentByTag("frag_camera"));
        cameraHost = new SimpleCameraHost.Builder(getActivity()).useFrontFacingCamera(false).photoDirectory(getActivity().getCacheDir()).useFullBleedPreview(true).build();
        cameraFragment.setHost(cameraHost);
        getChildFragmentManager().beginTransaction().add(R.id.fl_camera, cameraFragment);
        return view;
    }
}
