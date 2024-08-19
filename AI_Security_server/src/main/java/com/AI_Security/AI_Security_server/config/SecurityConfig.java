package com.AI_Security.AI_Security_server.config;

import com.AI_Security.AI_Security_server.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Persolute
 * @version 1.0
 * @description Security Config
 * @email 1538520381@qq.com
 * @date 2024/04/29 13:39
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /*
     * @author Persolute
     * @version 1.0
     * @description 密码自动加密
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午1:41
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 注册身份验证管理器bean
     * @email 1538520381@qq.com
     * @date 2024/4/29 下午2:06
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/register").anonymous()
                .antMatchers("/user/login").anonymous()
                .antMatchers("/user/upload/avatar").anonymous()
                .antMatchers("/common/captcha").anonymous()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/test/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
