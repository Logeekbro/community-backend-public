package com.db.community.model.mtb;

import com.db.community.model.enums.Visible;

import static com.db.community.common.GlobalVars.MTB_PREFIX;


public class MTBFollow extends MiddleTable{
    public MTBFollow() {
    }

    public MTBFollow(Visible visible) {
        super(visible);
    }

    @Override
    public String tableName() {
        return MTB_PREFIX + "follow";
    }

    @Override
    public String firstFiledName() {
        return "parent_id";
    }

    @Override
    public String secondFiledName() {
        return "follower_id";
    }


}
