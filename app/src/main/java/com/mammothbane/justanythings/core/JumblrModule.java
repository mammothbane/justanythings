package com.mammothbane.justanythings.core;

import com.tumblr.jumblr.JumblrClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mammothbane on 1/27/2015.
 */

@Module(injects = JumblrClient.class)
public class JumblrModule {
    @Provides @Singleton
    JumblrClient getJumblr() {
        throw new UnsupportedOperationException();
    }
}
