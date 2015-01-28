package com.mammothbane.justanythings;

import android.app.Application;
import android.support.annotation.NonNull;

import com.mammothbane.justanythings.core.CameraModule;
import com.mammothbane.justanythings.core.JumblrModule;
import com.mammothbane.justanythings.core.MainModule;

import dagger.ObjectGraph;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class App extends Application {

    private static App instance;
    private static ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        inject(this);
    }

    public static void inject(Object dep) {
        if (graph == null) {
            graph = ObjectGraph.create(new JumblrModule(), new CameraModule(), new MainModule(instance));
        }
        graph.inject(dep);
    }

    @NonNull
    public static App get() {
        if (instance != null) return instance;
        else throw new NullPointerException("app instance was null");
    }
}
