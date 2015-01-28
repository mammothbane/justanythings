package com.mammothbane.justanythings.core;

import android.hardware.Camera;

import com.mammothbane.justanythings.fragments.CameraFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mammothbane on 1/27/2015.
 */

@Module ( injects = CameraFragment.class )
public class CameraModule {
    @Provides
    Camera getCamera() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception ignore) {}
        return c;
    }

}
