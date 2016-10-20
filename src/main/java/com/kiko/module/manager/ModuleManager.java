package com.kiko.module.manager;

import com.kiko.core.NetObject;
import com.kiko.module.AbstractModuleManager;
import com.kiko.module.Module;

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
        if (null != modules)
        modules.add(module);
    }

    @Override
    public void installAllModules() {
//        if (ConditionUtils.isEmpty(modules))return;
//        // 遍历模块
//        for (Iterator<Module> mit = modules.iterator() ; mit.hasNext(); ) {
//            Module module = mit.next();
//            // 遍历区
//            for (Iterator<Sector> sit = module.sectors.iterator() ; sit.hasNext(); ) {
//                Sector sector = sit.next();
//                // 生产配置
//                NetUnitOption option= sector.produce();
//                // 装载配置
//                leaderNetObj.netUnit.setOption(option);
//            }
//        }
    }


}
