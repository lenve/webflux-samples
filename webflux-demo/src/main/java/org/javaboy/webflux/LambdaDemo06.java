package org.javaboy.webflux;

import java.util.function.Consumer;

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
interface ICalculator2{
    int add(int a, int b);
}
@FunctionalInterface
interface ICalculator3{
    int multiply(int a, int b);
}
public class LambdaDemo06 {
    public static void main(String[] args) {
        calculator((ICalculator2) (a, b) -> a + b);
    }

    public static void calculator(ICalculator2 iCalculator) {
    }
    public static void calculator(ICalculator3 iCalculator) {
    }
}
