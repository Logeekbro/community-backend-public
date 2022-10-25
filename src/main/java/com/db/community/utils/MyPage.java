package com.db.community.utils;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.db.community.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class MyPage<T> implements Serializable {

    private Long current;

    private Long size;

    private Long total;

    private List<T> records;

    // 不返回给前端的属性
    @JsonIgnore
    private String sql = "";

    /**
     * 空的page
     * @param current
     * @param size
     */
    public MyPage(Long current, Long size){
        this.current = current;
        this.size = size;
        this.total = 0L;
        this.records = new ArrayList<>();
    }

    /**
     * 用法：通过构造方法将要分页的对象的mapper传进来，
     * 然后将返回的page对象中的sql属性作为mapper的lastSql
     * 再将获取的记录放入page的records属性中
     * @param mapper
     * @param current
     * @param size
     */
    public MyPage(BaseMapper<?> mapper, Long current, Long size){
        this.current = Objects.isNull(current) ? 1 : current;
        this.current = this.current > 0 ? this.current : 1;
        this.size = Objects.isNull(size) ? 0 : size;
        this.size = this.size > 0 ? this.size : 1;
        this.total = mapper.selectCount(null);
        if(this.total == 0) return;
        this.sql = "LIMIT " + ((this.current - 1) * this.size) + "," + this.size;
    }

    /**
     * 带条件版（传入queryWrapper）
     * @param mapper
     * @param current
     * @param size
     */
    public MyPage(BaseMapper mapper, AbstractWrapper queryWrapper, Long current, Long size){
        this.current = Objects.isNull(current) ? 1 : current;
        this.current = this.current > 0 ? this.current : 1;
        this.size = Objects.isNull(size) ? 0 : size;
        this.size = this.size > 0 ? this.size : 1;
        this.total = mapper.selectCount(queryWrapper);
        if(total == 0) return;
        this.sql = "LIMIT " + ((this.current - 1) * this.size) + "," + this.size;
        queryWrapper.last(this.sql);
    }
}
