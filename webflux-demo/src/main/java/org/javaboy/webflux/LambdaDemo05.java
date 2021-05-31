package org.javaboy.webflux;

import java.util.Arrays;
import java.util.Random;
import java.util.function.*;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
class Cat{

}
public class LambdaDemo05 {
    public static void main(String[] args) {
//        Function<Integer, String> func = String::valueOf;
//        String s = func.apply(99);
//        System.out.println("s = " + s);
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("javaboy");
//        BiFunction<Integer, Integer, Double> func = Math::pow;
//        Double result = func.apply(4, 3);
//        System.out.println("result = " + result);
//        Random random = new Random();
//        IntUnaryOperator func = i -> random.nextInt(i);
//        Integer r = func.applyAsInt(10);
//        System.out.println("r = " + r);
//        String[] stringArray = {"Barbara", "Mary", "James"};
//        Arrays.sort(stringArray, String::compareToIgnoreCase);
//        System.out.println(Arrays.toString(stringArray));
//        Supplier<Cat> supplier = Cat::new;
//        Cat cat = supplier.get();
//        IntFunction<int[]> func = int[]::new;
//        int[] arr = func.apply(10);
//        System.out.println("arr.length = " + arr.length);
        String s = "javaboy";
        Consumer<String> consumer = s1 -> System.out.println(s1 + s);
        consumer.accept("hello ");
    }
}
