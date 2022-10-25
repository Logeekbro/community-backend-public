package com.db.community.service;

import com.db.community.model.vo.VerifyVO;

public interface VerifyService {

    String handleVerify(String verifyId, String value);

    VerifyVO startVerify();

    void loadVerifyWordFromDB();
}
