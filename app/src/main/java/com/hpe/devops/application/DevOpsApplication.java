package com.hpe.devops.application;

import android.app.Application;

import dagger.ObjectGraph;
import timber.log.Timber;

public class DevOpsApplication extends Application {

    protected static ObjectGraph objectGraph;
    private static DevOpsApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.uprootAll(); // remove in dev builds to see logs written by module creation
        instance = this;
        objectGraph = ObjectGraph.create(getModules());
        inject(this);
    }

    protected Object[] getModules() {
        Object[] modules = {new DevOpsModule(this)};
        return modules;
    }

    public static void inject(Object object) {
        objectGraph.inject(object);
    }

    public static <T> T get(Class<T> clazz) {
        return objectGraph.get(clazz);
    }
}
