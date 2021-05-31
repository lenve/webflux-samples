package org.javaboy.webflux;

import java.util.Random;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class StreamDemo03 {
    public static void main(String[] args) {
        new Random().ints().limit(50).parallel().forEach(i->{
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        });
    }
}
