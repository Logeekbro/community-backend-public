package com.db.community.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 当返回值为基本数据类型、String、Boolean时，使用该VO封装成键为value的json数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleKeyVO implements Serializable {

    private Object value;


}
