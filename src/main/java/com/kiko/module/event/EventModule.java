package com.kiko.module.event;

import com.kiko.module.AbstractModuleManager;
import com.kiko.module.ModuleType;
import com.kiko.module.Module;
import com.kiko.module.Sector;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public class EventModule extends Module{

    public EventModule(AbstractModuleManager owner) {
        super(owner);
        type = ModuleType.EVENT;
    }

    @Override
    public void init() {
    }

    @Override
    public void loadSector(Sector sector) {
    }

}
