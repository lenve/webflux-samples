package org.javaboy.webflux;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.*;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class StreamDemo02 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Stream<String> s1 = list.stream();
//        Set<String> set = new HashSet<>();
//        Stream<String> s2 = set.stream().map();
//        String[] arr = {"1", "2", "3"};
//        Stream<String> s1 = Arrays.stream(arr);
//        Stream<Integer> s2 = s1.map(i -> Integer.valueOf(i));
//        IntStream.of(1, 2, 3).map.map(i -> 2 * i).forEach(System.out::println);
//        DoubleStream s2 = DoubleStream.of(1, 2, 3);
//        LongStream s3 = LongStream.of(1L, 2L, 3L);
//        Random random = new Random();
//        Supplier<Integer> supplier = () -> random.nextInt(100);
//        Stream<Integer> stream = Stream.generate(supplier).limit(5);
//        System.out.println("stream.toArray() = " + Arrays.toString(stream.toArray()));
//        String[] arr = {"1", "2", "3"};
//        Stream<String> s1 = Arrays.stream(arr);
//        s1.mapToLong(i -> Long.parseLong(i)).forEach(System.out::println);
//        Stream<Integer> s = Stream.of(new Integer[]{1, 2, 3}, new Integer[]{4, 5, 6}, new Integer[]{7, 8, 9}).flatMap( i -> Arrays.stream(i));
//        s.forEach(System.out::println);
//        IntStream.of(2, 3, 4, 5, 6, 7).filter(i -> i > 3).forEach(System.out::println);
//        IntStream.of(2, 3, 4, 5, 6, 7).filter(i -> i > 3).peek(String::valueOf).forEach(i-> System.out.println(i));
//        IntStream.of(2, 3, 4, 3, 7, 6, 2, 5, 6, 7).distinct().forEachOrdered(System.out::println);
//        IntStream.of(2, 3, 4, 3, 7, 6, 2, 5, 6, 7).distinct().sorted().forEach(System.out::println);
//        Arrays.asList('A', 'B', 'C', 'D', 'E', 'F').stream().skip(2).limit(3).forEach(System.out::println);
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Arrays.stream(arr).collect(Collectors.toList());
        //        Arrays.stream(arr).parallel().forEach(System.out::println);
//        Arrays.stream(arr).parallel().forEachOrdered(System.out::println);
//        List<Integer> list = Stream.of(1, 2, 3, 4).filter(p -> p > 2).collect(Collectors.toList());
//        System.out.println(list);
//        Optional<Integer> optional = Stream.of(1, 2, 3, 4).reduce((i, j) -> i + j);
//        System.out.println(optional.orElse(-1));
//        Optional<String> s = Stream.of("wwwjavaboyorg".split("")).reduce((i, j) -> i + "." + j);
//        System.out.println(s.orElse(""));
//        long count = s.count();
//        System.out.println("count = " + count);
//        Stream<Integer> s = Stream.of(1, 2, 3, 4);
//        Optional<Integer> min = s.min(Comparator.comparingInt(i -> i));
//        System.out.println("min.get() = " + min.get());
//        for (int i = 0; i < 10; i++) {
//            Optional<Integer> first = Stream.of(1, 2, 3, 4).parallel().findFirst();
//            System.out.println("first.get() = " + first.get());
//        }
//        System.out.println("=============");
//        for (int i = 0; i < 10; i++) {
//            Optional<Integer> first = Stream.of(1, 2, 3, 4).parallel().findAny();
//            System.out.println("first.get() = " + first.get());
//        }
        boolean b = Stream.of(1, 2, 3, 4).allMatch(i -> i > 3);
        System.out.println("b = " + b);
    }

}
