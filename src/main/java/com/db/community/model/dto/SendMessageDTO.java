package com.db.community.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
public class SendMessageDTO implements Serializable {

    private Integer senderId;

    private Integer targetId;

    private String content;


}
