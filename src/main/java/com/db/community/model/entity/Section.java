package com.db.community.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Section {

    private Integer sectionId;
    private String sectionName;
    private Date createTime;
    private Date modifyTime;
    private Boolean deleted;
}
