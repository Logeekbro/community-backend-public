package com.db.community.mapper;

import com.db.community.model.entity.Article;
import com.db.community.model.mtb.MiddleTable;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Mapper
public interface MiddleTableMapper {

    @Insert("INSERT INTO " +
            "${table.tableName()}" +
            "(${table.firstFiledName()}, ${table.secondFiledName()}, ${table.createTime()}) " +
            "VALUES(#{id1}, #{id2}, NOW())")
    void insertRelationById(@Param("table") MiddleTable table,
                            @Param("id1") Serializable id1,
                            @Param("id2") Serializable id2);


    @Select("SELECT COUNT(*) FROM ${table.tableName()} " +
            "WHERE ${table.firstFiledName()}=#{id1} AND ${table.secondFiledName()}=#{id2} " +
            "${table.visible()}")
    boolean checkRelationById(@Param("table") MiddleTable table,
                              @Param("id1") Serializable id1,
                              @Param("id2") Serializable id2);

    @Delete("DELETE FROM ${table.tableName()} " +
            "WHERE ${table.firstFiledName()}=#{id1} AND ${table.secondFiledName()}=#{id2}")
    boolean deleteRelationById(@Param("table") MiddleTable table,
                               @Param("id1") Serializable id1,
                               @Param("id2") Serializable id2);

    @Select("SELECT COUNT(*) FROM ${table.tableName()} " +
            "WHERE ${table.firstFiledName()}=#{id1} " +
            "${table.visible()}")
    Long selectCountById1(@Param("table") MiddleTable table,
                          @Param("id1") Serializable id1);

    @Select("SELECT COUNT(*) FROM ${table.tableName()} " +
            "WHERE ${table.secondFiledName()}=#{id2} " +
            "${table.visible()}")
    Long selectCountById2(@Param("table") MiddleTable table,
                          @Param("id2") Serializable id2);

    @Select("SELECT ${table.firstFiledName()} FROM ${table.tableName()} " +
            "WHERE ${table.secondFiledName()}=#{id2} " +
            "${table.visible()}")
    List<String> selectId1ListById2(MiddleTable table, Serializable id2);

    @Select("SELECT ${table.secondFiledName()} FROM ${table.tableName()} " +
            "WHERE ${table.firstFiledName()}=#{id1} " +
            "${table.visible()}")
    List<String> selectId2ListById1(MiddleTable table, Serializable id1);


    @Insert("INSERT IGNORE INTO " +
            "${table.tableName()}" +
            "(${table.firstFiledName()}, ${table.secondFiledName()}, ${table.createTime()}) " +
            "VALUES(#{id1}, #{id2}, NOW())")
    Boolean insertRelationIfNotExist(@Param("table") MiddleTable table,
                                  @Param("id1") Serializable id1,
                                  @Param("id2") Serializable id2);
}
