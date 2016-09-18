package com.kiko.module;

import com.kiko.tools.ConditionUtils;

import java.util.Collection;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class AbstractModuleManager {

    private Collection<Module> modules;

    public abstract void addModule();

    public abstract Module findModule();

    public boolean hasRemainModule() {return ConditionUtils.isEmpty(modules);}

}
