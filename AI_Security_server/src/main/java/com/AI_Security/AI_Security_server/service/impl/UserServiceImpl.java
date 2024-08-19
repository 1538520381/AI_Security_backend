package com.AI_Security.AI_Security_server.service.impl;

import com.AI_Security.AI_Security_server.entity.bo.MyUserDetails;
import com.AI_Security.AI_Security_server.entity.po.User;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.entity.vo.LoginVO;
import com.AI_Security.AI_Security_server.entity.vo.RegisterVO;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.mapper.UserMapper;
import com.AI_Security.AI_Security_server.service.UserService;
import com.AI_Security.AI_Security_server.utils.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Persolute
 * @version 1.0
 * @description User ServiceImpl
 * @email 1538520381@qq.com
 * @date 2024/04/29 10:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private AuthenticationManager ProviderManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /*
     * @author Persolute
     * @version 1.0
     * @description 注册
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午9:11
     */
    @Override
    public R register(RegisterVO registerVO) {
        User user = getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, registerVO.getPhone()).eq(User::getIsDeleted, false));
        if (!Objects.isNull(user)) {
            throw new CustomerException("账号已存在");
        }
        user = new User();
        user.setPhone(registerVO.getPhone());
        user.setPassword(passwordEncoder.encode(registerVO.getPassword()));
        user.setNickName(registerVO.getNickName());
        user.setAvatar(registerVO.getAvatar());
        user.setType(registerVO.getType());
        user.setStatus(0);
        user.setIsDeleted(false);
        save(user);
        return R.success("注册成功");
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 登录
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午1:59
     */
    @Override
    public R login(LoginVO loginVO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVO.getPhone(), loginVO.getPassword());
        Authentication authentication = ProviderManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) {
            throw new CustomerException("用户名或密码错误");
        }
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        if (!user.getType().equals(loginVO.getType())) {
            throw new CustomerException("该账号不存在");
        } else if (user.getStatus().equals(1)) {
            throw new CustomerException("账号已被禁用，请联系管理员");
        }

        Long userId = user.getId();
        redisTemplate.opsForValue().set("login_" + userId, userDetails);
        return R.success("登录成功").put("token", userId).put("type", user.getType());
    }
}
