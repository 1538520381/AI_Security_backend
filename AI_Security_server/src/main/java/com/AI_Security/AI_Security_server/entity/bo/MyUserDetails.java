package com.AI_Security.AI_Security_server.entity.bo;

import com.AI_Security.AI_Security_server.entity.po.User;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Persolute
 * @version 1.0
 * @description UserDetails
 * @email 1538520381@qq.com
 * @date 2024/04/29 14:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUserDetails implements UserDetails {
    // 用户
    private User user;

    // 权限信息
    private List<String> permissions;

    // SpringSecurity权限信息集合
    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
