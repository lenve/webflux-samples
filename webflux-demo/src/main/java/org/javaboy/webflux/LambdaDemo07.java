package org.javaboy.webflux;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class LambdaDemo07 {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, IntFunction<Integer>>> func = x -> y -> z -> x + y + z;
        Integer i = func.apply(3).apply(4).apply(5);
        System.out.println("i = " + i);
    }
}
