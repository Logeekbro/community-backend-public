package com.db.community.model.document.message;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("user-private-messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserPrivateMessage extends UserMessage {

    private Integer senderId;

    private Integer targetId;

    private String content;


}
