package com.hpe.devops.application;

import android.content.Context;

import com.hpe.devops.activity.LauncherActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                Context.class,
                LauncherActivity.class,
                DevOpsApplication.class,
        })
public class DevOpsModule {
    private Context context;

    public DevOpsModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return context;
    }
}
