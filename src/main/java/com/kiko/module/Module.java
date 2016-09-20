package com.kiko.module;

import java.util.Collection;
import java.util.List;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public abstract class Module {
    // 模块类型
    protected MODULE_TYPE type;
    // 子模块集合
    public Collection<Sector> sectors;
    // 模块管理类
    public AbstractModuleManager leaderModuleManager;

    public Module(AbstractModuleManager owner) {
        this.leaderModuleManager = owner;
    }
    // 模块初始化
    public abstract void init();
    // 装载子模块
    public abstract void loadSector(Sector sector);

    //public abstract void loadSectors(List<Sector> sectors);

}
