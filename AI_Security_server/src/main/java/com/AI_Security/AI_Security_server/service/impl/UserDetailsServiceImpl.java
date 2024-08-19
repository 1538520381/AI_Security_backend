package com.AI_Security.AI_Security_server.service.impl;

import com.AI_Security.AI_Security_server.entity.bo.MyUserDetails;
import com.AI_Security.AI_Security_server.entity.po.User;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Persolute
 * @version 1.0
 * @description UserDetails ServiceImpl
 * @email 1538520381@qq.com
 * @date 2024/04/29 15:04
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone).eq(User::getIsDeleted, false));
        if (Objects.isNull(user)) {
            throw new CustomerException("用户不存在");
        }
        List<String> list = new ArrayList<>(Arrays.asList("test"));
        return new MyUserDetails(user, list);
    }
}
