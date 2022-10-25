package com.db.community.handler;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 配置MybatisPlus自动填充字段
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    //添加时自动填充 setFieldValByName三个参数为：映射类字段，填充值，原对象
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("modifyTime", new Date(), metaObject);
        this.setFieldValByName("nickName", "用户" + UUID.fastUUID().toString(true), metaObject);
    }

    //更新时自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modifyTime", new Date(), metaObject);
    }
}
