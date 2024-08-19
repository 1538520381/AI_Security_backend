package com.AI_Security.AI_Security_server.filter;

import com.AI_Security.AI_Security_server.entity.bo.MyUserDetails;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Persolute
 * @version 1.0
 * @description Token过滤器
 * @email 1538520381@qq.com
 * @date 2024/04/29 23:02
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String userId = token;
//        try {
//            Claims claims = JwtUtil.parseJwt(token);
//            userId = claims.getSubject();
//        } catch (Exception e) {
//            throw new CustomerException("非法token");
//        }


        MyUserDetails userDetails = (MyUserDetails) redisTemplate.opsForValue().get("login_" + userId);
        if (Objects.isNull(userDetails)) {
            throw new CustomerException("用户未登录");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
