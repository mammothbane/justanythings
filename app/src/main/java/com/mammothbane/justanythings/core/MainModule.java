package com.mammothbane.justanythings.core;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mammothbane on 9/26/2014.
 */

@Module ( injects = Application.class )
public class MainModule {
    private Application application;

    public MainModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application getApplication() {
        return application;
    }

}
