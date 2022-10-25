package com.db.community.model.mtb;


import com.db.community.model.enums.Visible;
import org.springframework.stereotype.Component;

import static com.db.community.common.GlobalVars.MTB_PREFIX;

@Component
public class MTBArticleTag extends MiddleTable{

    public MTBArticleTag() {
    }

    public MTBArticleTag(Visible visible){
        super(visible);
    }

    @Override
    public String tableName(){
        return MTB_PREFIX + "article_tag";
    }

    @Override
    public String firstFiledName(){
        return "article_id";
    }

    @Override
    public String secondFiledName(){
        return "tag_id";
    }


}
