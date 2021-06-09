package org.javaboy.webflux_router.router;

import org.javaboy.webflux_router.handler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Configuration
public class RouterConfiguration {
    @Bean
    RouterFunction<ServerResponse> personRouter(PersonHandler personHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/person"), RouterFunctions.route(RequestPredicates.POST("/"), personHandler::addPerson).andRoute(RequestPredicates.GET("/"), personHandler::getAllPerson).andRoute(RequestPredicates.DELETE("/{id}"), personHandler::deletePerson));
    }
}
