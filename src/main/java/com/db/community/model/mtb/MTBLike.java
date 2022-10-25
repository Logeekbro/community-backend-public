package com.db.community.model.mtb;

public class MTBLike extends MiddleTable{
    @Override
    String tableName() {
        return "mtb_like";
    }

    @Override
    String firstFiledName() {
        return "user_id";
    }

    @Override
    String secondFiledName() {
        return "aoc_id";
    }
}
