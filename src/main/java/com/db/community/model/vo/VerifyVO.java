package com.db.community.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyVO {

    private String verifyId;
    private Set<String> words;
    private List<Character> order;
}
