package com.AI_Security.AI_Security_server.utils;


import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;


/**
 * @author Persolute
 * @version 1.0
 * @description JWT 工具类
 * @email 1538520381@qq.com
 * @date 2024/04/29 15:41
 */
public class JwtUtil {
//    public static final Long JWT_TTL = 15 * 24 * 60 * 60 * 1000L;
//    public static final String JWT_KEY = "TrustyFL";
//
//    /*
//     * @author Persolute
//     * @version 1.0
//     * @description 生成uuid
//     * @email 1538520381@qq.com
//     * @date 2024/4/29 下午5:09
//     */
//    public static String getUUID() {
//        return UUID.randomUUID().toString().replaceAll("-", "");
//    }
//
//    /*
//     * @author Persolute
//     * @version 1.0
//     * @description 生成token(默认生效时间)
//     * @email 1538520381@qq.com
//     * @date 2024/4/29 下午5:13
//     */
//    public static String createJWT(String subject) {
//        return getJwtBuilder(subject, null, getUUID()).compact();
//    }
//
//    /*
//     * @author Persolute
//     * @version 1.0
//     * @description 生成token(自定义生效时间)
//     * @email 1538520381@qq.com
//     * @date 2024/4/29 下午8:44
//     */
//    public static String createJWT(String subject, Long ttlMillis) {
//        return getJwtBuilder(subject, ttlMillis, getUUID()).compact();
//    }
//
//    /*
//     * @author Persolute
//     * @version 1.0
//     * @description 解析token
//     * @email 1538520381@qq.com
//     * @date 2024/4/29 下午8:45
//     */
//    public static Claims parseJwt(String jwt) {
//        SecretKey secretKey = generalKey();
//        return Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(jwt)
//                .getBody();
//    }
//
//    private static SecretKey generalKey() {
//        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
//        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//    }
//
//    private static JwtBuilder getJwtBuilder(String subject, Long ttlMills, String uuid) {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        SecretKey secretKey = generalKey();
//        long currentTimeMillis = System.currentTimeMillis();
//        Date now = new Date(currentTimeMillis);
//        Date exp = new Date(currentTimeMillis + (ttlMills == null ? JwtUtil.JWT_TTL : ttlMills));
//        return Jwts.builder()
//                .setId(uuid)
//                .setSubject(subject)
//                .setIssuedAt(now)
//                .signWith(signatureAlgorithm, secretKey)
//                .setExpiration(exp);
//    }
}
