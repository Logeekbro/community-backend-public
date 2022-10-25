package com.db.community.model.document.message;

import com.db.community.model.enums.DisplayName;
import com.db.community.model.enums.NotionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LikeNotion extends Notion implements Serializable {

    /**
     * 点赞者id
     */
    private Integer likeUserId;

    /**
     * 被点赞的文章或评论id
     */
    private String beLikeId;

    /**
     * 被点赞的文章或评论的作者id
     */
    private Integer targetId;

    /**
     * 提醒类型，用于标识点赞的是文章还是评论
     */
    private NotionType notionType;

    /**
     * 用于标识通知的类别，如：点赞通知、文章审核结果通知等...
     */
    private DisplayName displayName;



    public LikeNotion(Integer likeUserId, String beLikeId) {
        this.likeUserId = likeUserId;
        this.beLikeId = beLikeId;
        this.notionType = NotionType.ARTICLE;
        this.displayName = DisplayName.LIKE_NOTION;
    }

    public LikeNotion(Integer likeUserId, String beLikeId, NotionType type) {
        this(likeUserId, beLikeId);
        this.notionType = type;
    }
}
