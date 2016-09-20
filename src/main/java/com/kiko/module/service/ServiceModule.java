package com.kiko.module.service;

import com.kiko.module.AbstractModuleManager;
import com.kiko.module.MODULE_TYPE;
import com.kiko.module.Module;
import com.kiko.module.Sector;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public class ServiceModule extends Module{

    public ServiceModule(AbstractModuleManager owner) {
        super(owner);
        sectors = new CopyOnWriteArrayList<Sector>();
        type = MODULE_TYPE.SERVICE;
    }

    @Override
    public void init() {
    }

    @Override
    public void loadSector(Sector sector) {
        sectors.add(sector);
    }

}
