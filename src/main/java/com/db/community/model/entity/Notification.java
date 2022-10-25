package com.db.community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_notification
 */
@TableName(value ="tb_notification")
@Data
public class Notification implements Serializable {
    /**
     * 通知id
     */
    @TableId(type = IdType.AUTO)
    private Integer notificationId;

    /**
     * 通知内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否显示， 0不显示，1显示
     */
    private Integer display;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}