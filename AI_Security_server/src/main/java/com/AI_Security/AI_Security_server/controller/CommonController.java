package com.AI_Security.AI_Security_server.controller;

import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.service.CommonService;
import org.apache.commons.io.IOUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Persolute
 * @version 1.0
 * @description common Controller
 * @email 1538520381@qq.com
 * @date 2024/04/29 11:40
 */
@CrossOrigin
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    /*
     * @author Persolute
     * @version 1.0
     * @description 获取图形验证码
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午12:45
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse httpServletResponse, String uuid) throws IOException {
        if (StringUtils.isBlank(uuid)) {
            throw new CustomerException("uuid不能为空");
        }

        httpServletResponse.setHeader("Cache-Control", "no-store, no-cache");
        httpServletResponse.setContentType("image/jpeg");
        BufferedImage image = commonService.getCaptcha(uuid);
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        ImageIO.write(image, "jpg", servletOutputStream);
        IOUtils.closeQuietly(servletOutputStream);
    }
}
