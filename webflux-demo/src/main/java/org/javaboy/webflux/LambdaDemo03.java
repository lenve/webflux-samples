package org.javaboy.webflux;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
class User2 {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String say(UnaryOperator<String> sayHello) {
        return sayHello.apply(this.username);
    }
}
public class LambdaDemo03 {
    public static void main(String[] args) {
        User2 user2 = new User2();
        user2.setUsername("javaboy");
        UnaryOperator<String> func = (username) -> "helloo " + username;
        String say = user2.say(func);
        System.out.println("say = " + say);
    }
}
