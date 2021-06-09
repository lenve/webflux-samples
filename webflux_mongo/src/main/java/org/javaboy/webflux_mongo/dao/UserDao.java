package org.javaboy.webflux_mongo.dao;

import org.javaboy.webflux_mongo.bean.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@EnableMongoRepositories
public interface UserDao extends ReactiveMongoRepository<User,String> {
    Flux<User> findUserByUsernameContaining(String name);
}
