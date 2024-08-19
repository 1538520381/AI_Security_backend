package com.AI_Security.AI_Security_server.service;

import com.AI_Security.AI_Security_server.entity.po.User;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.entity.vo.LoginVO;
import com.AI_Security.AI_Security_server.entity.vo.RegisterVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Persolute
 * @version 1.0
 * @description User Service
 * @email 1538520381@qq.com
 * @date 2024/04/29 10:09
 */
public interface UserService extends IService<User> {
    R register(RegisterVO registerVO);

    R login(LoginVO loginVO);
}
