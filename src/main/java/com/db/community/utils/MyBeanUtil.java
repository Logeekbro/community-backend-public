package com.db.community.utils;

import cn.hutool.core.bean.BeanUtil;

public class MyBeanUtil {

    public static <T> T copyProps(Object source, Class<T> clazz) {
        return BeanUtil.copyProperties(source, clazz);
//        try {
//            T dest = clazz.newInstance();
//            BeanUtils.copyProperties(source, dest);
//            return dest;
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//            throw new ApiException("数据有误");
//        }
    }
}
