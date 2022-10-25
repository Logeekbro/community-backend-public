package com.db.community.model.vo.impl;

import com.db.community.model.vo.TagVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagIdAndNameVO implements TagVO, Serializable {

    @JsonProperty("tagId")
    private String tagId;
    @JsonProperty("tagName")
    private String tagName;
}
