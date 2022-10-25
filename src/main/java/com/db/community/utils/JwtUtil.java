package com.db.community.utils;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.db.community.common.GlobalVars;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 */
public class JwtUtil {

    //有效期为
    public static final Long JWT_TTL = GlobalVars.JWT_EXPIRE;
    //设置秘钥明文
    public static final String JWT_KEY = GlobalVars.JWT_KEY;

    public static String getUUID(){
        return UUID.fastUUID().toString(true);
    }

    /**
     * 生成jwt
     * @param map token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(Map<?, ?> map){
        String jsonString = JSONObject.toJSONString(map);
        JwtBuilder builder = getJwtBuilder(jsonString, null, getUUID());
        return builder.compact();
    }

    /**
     * 生成jwt
     * @param subject token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }



    /**
     * 生成jwt
     * @param subject token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis == null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)              //唯一的ID
                .setSubject(subject)   // 主题  可以是JSON数据
                .setIssuer("db")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, secretKey) //使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(expDate);        // 过期时间
    }

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }



    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
        }
        catch (Exception e){
//            ApiAsserts.fail("token有误，请尝试刷新页面");
//            e.printStackTrace();
        }
        return null;
    }

    public static Integer getUserId(String userToken){
        return Integer.parseInt(parseJWT(userToken).getSubject());
    }

    public static void main(String[] args) throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhMWI2ZjJjYjAwYTA0OTY2YmQwOTZjZTA0ZjZkMGJiNyIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTY1MjUxNDcxOCwiZXhwIjoxNjUyNTE4MzE4fQ.8e89oMHwXcFdFNgyENzwHC0zlj2lhP1SrHWCY1GA2IY";
        Claims claims = parseJWT(token);
        System.out.println(claims);
    }
}
