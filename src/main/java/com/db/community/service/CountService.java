package com.db.community.service;

import com.db.community.model.enums.CountType;

public interface CountService {

    Double getLikeCountById(String articleId);


    void handleCount(CountType countType, String id, Boolean isAdd);

    Integer getCount(CountType countType, String id);

    void loadCacheFromDB();

    void saveCacheToDB();
}
