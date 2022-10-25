package com.db.community.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class VerifyDTO implements Serializable {

    // 正确的汉字顺序组合
    private String correctValue;
    // 用于转成图片的字符串数组
    private String[] strArr;
}
