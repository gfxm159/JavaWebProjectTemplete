package com.self.api.support.utils;

import java.util.UUID;

/**
 * @author ShiXin
 * @date 2018/7/12 17:24
 */
public class CommonUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
