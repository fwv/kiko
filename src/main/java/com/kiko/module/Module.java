package com.kiko.module;

import java.util.Collection;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class Module {

    protected ModuleType type;

    public Collection<Sector> sectors;

    public AbstractModuleManager leaderModuleManager;

    public Module(AbstractModuleManager owner) {
        this.leaderModuleManager = owner;
    }

    public abstract void init();

    public abstract void loadSector(Sector sector);

    //public abstract void loadSectors(List<Sector> sectors);

}
