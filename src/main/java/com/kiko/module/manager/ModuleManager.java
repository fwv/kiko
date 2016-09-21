package com.kiko.module.manager;

import com.kiko.core.NetObject;
import com.kiko.module.AbstractModuleManager;
import com.kiko.module.Module;
import com.kiko.module.Sector;
import com.kiko.module.service.ServiceSector;
import com.kiko.netty.impl.NetUnitOption;
import com.kiko.tools.ConditionUtils;

import java.util.Iterator;
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

    @Override
    public void InstallAllModules() {
        if (ConditionUtils.isEmpty(modules))return;
        // ����ģ��
        for (Iterator<Module> mit = modules.iterator() ; mit.hasNext(); ) {
            Module module = mit.next();
            // ������
            for (Iterator<Sector> sit = module.sectors.iterator() ; sit.hasNext(); ) {
                Sector sector = sit.next();
                // ��������
                NetUnitOption option= sector.produce();
                // װ������
                leaderNetObj.netUnit.setOption(option);
            }
        }
    }


}
