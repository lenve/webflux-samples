package org.javaboy.webflux;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        //1,4,9,16,25,36
//        double asDouble = IntStream.of(arr).average().getAsDouble();
        double[] arr = {1, 2, 3, 4, 5, 6};
        DoubleStream doubleStream = DoubleStream.of(arr).map(i -> Math.pow(i, 2));
        double sum = doubleStream.sum();
        System.out.println("sum = " + sum);
//        System.out.println("asDouble = " + asDouble);
    }
}
