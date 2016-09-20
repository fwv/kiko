package com.kiko.module.db;

import com.kiko.module.AbstractModuleManager;
import com.kiko.module.MODULE_TYPE;
import com.kiko.module.Module;
import com.kiko.module.Sector;

/**
 * @Author fengwei
 * Created on 2016/9/18/0018.
 */
public class DBModule extends Module{

    public DBModule(AbstractModuleManager owner) {
        super(owner);
        type = MODULE_TYPE.DB;
    }

    @Override
    public void init() {

    }

    @Override
    public void loadSector(Sector sector) {

    }


}
