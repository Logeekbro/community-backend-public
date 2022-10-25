package com.db.community.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.db.community.common.GlobalVars;
import com.db.community.exception.ApiAsserts;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

public class OSSUtil {

    private static OSS getClient(){
        try {
            return new OSSClientBuilder().build(GlobalVars.OSS_ENDPOINT, GlobalVars.ALIYUN_AK, GlobalVars.ALIYUN_AS);
        }
        catch (Exception e){
            e.printStackTrace();
            ApiAsserts.fail("文件服务异常");
            return null;
        }
    }

    public static boolean uploadObject(String objectName, MultipartFile file) {
        try {
            OSS client = getClient();
            assert client != null;
            client.putObject(GlobalVars.BUCKET_NAME, objectName, new ByteArrayInputStream(file.getBytes()));
            return true;
        }
        catch (Exception e) {
            ApiAsserts.fail("文件服务异常");
            return false;
        }
    }

}
