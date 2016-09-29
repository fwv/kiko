package com.kiko.module;

/**
 * @Author fengwei
 * Created on 2016/9/20/0020.
 */
public enum ModuleType {

    EVENT("eventModule", 1),
    SERVICE("serviceModule", 2),
    DB("dbModule", 3);

    private String name;
    private Integer index;

    private ModuleType(String name, Integer index) {
        this.name = name;
        this.index = index;
    }
}