package com.AI_Security.AI_Security_server.service;

import java.awt.image.BufferedImage;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/04/29 11:43
 */
public interface CommonService {
    BufferedImage getCaptcha(String uuid);

    void validateCaptcha(String uuid, String captcha);
}
