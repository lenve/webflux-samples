package org.javaboy.webflux_r2dbc.dao;

import org.javaboy.webflux_r2dbc.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public interface UserRepository extends ReactiveCrudRepository<User,Long> {

}
