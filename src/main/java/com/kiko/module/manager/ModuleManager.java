package com.kiko.module.manager;

import com.kiko.core.NetObject;
import com.kiko.module.AbstractModuleManager;
import com.kiko.module.Module;
import com.kiko.tools.ConditionUtils;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author fengwei
 * Created on 2016/9/20/0020.
 */
public class ModuleManager extends AbstractModuleManager{

    public ModuleManager(NetObject owner) {
        super(owner);
        modules = new CopyOnWriteArrayList<Module>();
    }

    @Override
    public Module findModule() {
        return null;
    }

    @Override
    public void loadModule(Module module) {
        if (!ConditionUtils.isEmpty(modules))
        modules.add(module);
    }
}
