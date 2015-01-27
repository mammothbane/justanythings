package com.mammothbane.justanythings.core;

import android.hardware.Camera;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mammothbane on 1/27/2015.
 */

@Module ( injects = Camera.class )
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
