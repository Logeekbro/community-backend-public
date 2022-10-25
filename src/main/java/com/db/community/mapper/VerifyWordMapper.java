package com.db.community.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VerifyWordMapper {

    @Select("SELECT word FROM tb_verifyword")
    Set<String> getWordSet();
}
