package com.kiko.tools;

import java.util.Collection;

/**
 * @Author fengwei
 * Created on 2016/9/13/0013.
 */
public class ConditionUtils {

    public static boolean isEmpty(Collection collection) {
        return null == collection || 0 == collection.size();
    }

}
