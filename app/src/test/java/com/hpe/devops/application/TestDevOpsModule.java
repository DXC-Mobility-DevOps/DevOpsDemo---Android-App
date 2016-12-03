package com.hpe.devops.application;

import android.content.Context;

import com.hpe.devops.activity.LauncherActivity;
import com.hpe.devops.activity.LauncherActivityTest;


import dagger.Module;

@Module(
        injects = {
                LauncherActivity.class,
                LauncherActivityTest.class,
                TestDevOpsApplication.class,
                DevOpsApplication.class,
        })
public class TestDevOpsModule {

}