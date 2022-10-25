package com.db.community.utils;

import org.springframework.data.mongodb.core.query.Criteria;

public class MongoUtil {

    public static Criteria notDeletedCriteria() {
        return Criteria.where("deleted").is(false);
    }
}
