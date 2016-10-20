package com.kiko.module;

import java.util.Collection;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class Module {

    protected ModuleType type;

    public AbstractModuleManager leaderModuleManager;

    public Module(AbstractModuleManager owner) {
        this.leaderModuleManager = owner;
    }

    public abstract void init();

}
