package com.hpe.devops.application;

public class TestDevOpsApplication extends DevOpsApplication {

    @Override
    protected Object[] getModules() {
        Object[] modules = {new TestDevOpsModule()};

        return modules;
    }
}