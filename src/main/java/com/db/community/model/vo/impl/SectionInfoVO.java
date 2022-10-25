package com.db.community.model.vo.impl;

import com.db.community.model.vo.SectionVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SectionInfoVO implements SectionVO, Serializable {

    private Integer sectionId;
    private String sectionName;
}
