package com.kiko.module;

import com.kiko.tools.ConditionUtils;

import java.util.Collection;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class AbstractModuleManager {

    protected Collection<Module> modules;

    public abstract Module findModule();

    public boolean hasRemainModule() {return ConditionUtils.isEmpty(modules);}

    public abstract void loadModule(Module module);

    public abstract void installAllModules();

}
