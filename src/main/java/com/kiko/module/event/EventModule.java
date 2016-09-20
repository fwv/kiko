package com.kiko.module.event;

import com.kiko.module.AbstractModuleManager;
import com.kiko.module.MODULE_TYPE;
import com.kiko.module.Module;
import com.kiko.module.Sector;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public class EventModule extends Module{

    public EventModule(AbstractModuleManager owner) {
        super(owner);
        type = MODULE_TYPE.EVENT;
    }

    @Override
    public void init() {

    }

    @Override
    public void loadSector(Sector sector) {
    }

}
