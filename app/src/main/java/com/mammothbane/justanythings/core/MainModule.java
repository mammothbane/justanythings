package com.mammothbane.justanythings.core;

import com.tumblr.jumblr.JumblrClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mammothbane on 9/26/2014.
 */

@Module ( injects = JumblrClient.class )
public class MainModule {

    @Provides @Singleton
    JumblrClient getJumblr() {
        throw new UnsupportedOperationException();
    }


}
