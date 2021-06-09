package org.javaboy.webflux_router.dao;

import org.javaboy.webflux_router.bean.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
public interface PersonRepository  extends ReactiveMongoRepository<Person,Long> {
}
