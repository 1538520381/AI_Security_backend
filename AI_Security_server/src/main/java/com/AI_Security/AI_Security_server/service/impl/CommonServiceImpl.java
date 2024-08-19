package com.AI_Security.AI_Security_server.service.impl;

import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.service.CommonService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/04/29 11:44
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private Producer defaultProducer;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /*
     * @author Persolute
     * @version 1.0
     * @description 获取图形验证码
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午12:40
     */
    @Override
    public BufferedImage getCaptcha(String uuid) {
        String code = defaultProducer.createText();
        redisTemplate.opsForValue().set("captcha_" + uuid, code, 5, TimeUnit.MINUTES);
        return defaultProducer.createImage(code);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 图形验证码效验
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午1:48
     */
    @Override
    public void validateCaptcha(String uuid, String captcha) {
        String s = String.valueOf(redisTemplate.opsForValue().get("captcha_" + uuid));
        if (s == null || s.equals("null")) {
            throw new CustomerException("验证码不存在或已失效，请重新获取验证码");
        }

        redisTemplate.delete("captcha_" + uuid);
        if (!s.equals(captcha)) {
            throw new CustomerException("验证码错误，请重新获取验证码");
        }
    }
}
