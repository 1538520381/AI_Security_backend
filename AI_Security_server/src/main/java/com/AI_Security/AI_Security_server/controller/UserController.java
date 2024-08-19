package com.AI_Security.AI_Security_server.controller;

import com.AI_Security.AI_Security_server.entity.po.User;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.entity.vo.LoginVO;
import com.AI_Security.AI_Security_server.entity.vo.RegisterVO;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.service.CommonService;
import com.AI_Security.AI_Security_server.service.UserService;
import com.AI_Security.AI_Security_server.utils.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Persolute
 * @version 1.0
 * @description User Controller
 * @email 1538520381@qq.com
 * @date 2024/04/29 10:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CommonService commonService;

    @Value("${TrustyFL-server.path.avatar}")
    private String avatarPath;

    /*
     * @author Persolute
     * @version 1.0
     * @description 头像上传
     * @email 1538520381@qq.com
     * @date 2024/4/30 上午10:01
     */
    @PostMapping("/upload/avatar")
    public R uploadAvatar(MultipartFile avatar) throws IOException {
        String originalFilename = avatar.getOriginalFilename();
        String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        avatar.transferTo(new File(avatarPath + newFilename));
        return R.success("上传成功").put("avatar", newFilename);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 头像下载
     * @email 1538520381@qq.com
     * @date 2024/7/30 下午3:26
     */
    @GetMapping("/download/avatar")
    public void downloadAvatar(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String token = httpServletRequest.getHeader("token");
        String userId = token;
//        try {
//            Claims claims = JwtUtil.parseJwt(token);
//            userId = claims.getSubject();
//        } catch (Exception e) {
//            throw new CustomerException("非法token");
//        }
        String avatar = userService.getById(userId).getAvatar();

        FileInputStream fileInputStream = new FileInputStream(avatarPath + avatar);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        httpServletResponse.setHeader("Cache-Control", "no-store, no-cache");
        httpServletResponse.setContentType("image/jpeg");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        fileInputStream.close();
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 用户注册
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午10:57
     */
    @PostMapping("/register")
    public R register(@RequestBody RegisterVO registerVO) {
//        commonService.validateCaptcha(registerVO.getUuid(), registerVO.getCaptcha());
        return userService.register(registerVO);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 登录
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午1:51
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginVO loginVO) {
        commonService.validateCaptcha(loginVO.getUuid(), loginVO.getCaptcha());
        return userService.login(loginVO);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 获取用户id
     * @email 1538520381@qq.com
     * @date 2024/7/30 下午3:12
     */
    @GetMapping("/getUserId")
    public R getUserId(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String userId = token;
//        try {
//            Claims claims = JwtUtil.parseJwt(token);
//            userId = claims.getSubject();
//        } catch (Exception e) {
//            throw new CustomerException("非法token");
//        }
        System.out.println("---");
        System.out.println(userId);
        System.out.println("---");
        return R.success().put("userId", userId);
    }
}
