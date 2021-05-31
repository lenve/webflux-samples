package org.javaboy.webflux;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@FunctionalInterface
interface SayHello {
    String sayHello(String name);
}

class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String say(SayHello sayHello) {
        return sayHello.sayHello(this.username);
    }
}

public class LambdaDemo02 {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("javaboy");
        String say = user.say((username) -> "hello " + username);
        System.out.println("say = " + say);
    }
}
