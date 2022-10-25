package com.db.community.model.vo.impl;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 富文本编辑器上传图片的响应数据格式
 */
@Data
public class ArticleImgVO implements Serializable {

    private List<String> errFiles;

    private Map<String, String> succMap;
}
