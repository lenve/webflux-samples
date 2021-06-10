package org.javaboy.webflux_r2dbc.config;

import org.javaboy.webflux_r2dbc.handler.UserHandler;
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
    RouterFunction<ServerResponse> userRouterFunction(UserHandler userHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.GET("/"), userHandler::getAllUsers)
                        .andRoute(RequestPredicates.POST("/"), userHandler::addUser)
                        .andRoute(RequestPredicates.DELETE("/{id}"), userHandler::deleteUser));
    }
}
