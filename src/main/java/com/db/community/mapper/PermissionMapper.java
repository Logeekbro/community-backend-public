package com.db.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("SELECT p.perm_key role FROM tb_user u INNER JOIN mtb_user_role ur ON u.user_id=ur.role_id INNER JOIN tb_role r " +
            "ON ur.role_id=r.role_id INNER JOIN mtb_role_permission rp" +
            " ON r.role_id=rp.role_id INNER JOIN tb_permission p ON rp.perm_id=p.perm_id")
    List<String> selectPermissionsByUserId(Integer userId);

    @Select("SELECT role_id FROM mtb_user_role WHERE user_id=#{userId}")
    List<Integer> selectRoleIdListByUserId(Integer userId);
}
