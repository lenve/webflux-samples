package org.javaboy.webflux.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
//@Configuration
public class SecurityConfig {
    @Bean
    MapReactiveUserDetailsService mapReactiveUserDetailsService() {
        UserDetails ud1 = User.withUsername("admin")
                .password("{noop}123")
                .roles("admin")
                .build();
        UserDetails ud2 = User.withUsername("zhangsan")
                .password("{noop}123")
                .roles("user")
                .build();
        return new MapReactiveUserDetailsService(ud1, ud2);
    }
}
