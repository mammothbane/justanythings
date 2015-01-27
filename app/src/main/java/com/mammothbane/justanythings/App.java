package com.mammothbane.justanythings;

import android.app.Application;
import android.util.Log;

import com.mammothbane.justanythings.core.CameraModule;
import com.mammothbane.justanythings.core.JumblrModule;
import com.mammothbane.justanythings.core.MainModule;

import dagger.ObjectGraph;

/**
 * Created by mammothbane on 9/26/2014.
 */
public class App extends Application {

    private static App instance;
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        instance = this;
        graph = ObjectGraph.create(new CameraModule(), new MainModule(this), new JumblrModule());
        graph.inject(this);
        Log.d("app", "INJECTED");
        super.onCreate();
    }

    public void inject(Object dep) {
        graph.inject(dep);
    }

    public static App get() {
        return instance;
    }
}
