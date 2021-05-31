package org.javaboy.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class Demo {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        initData(users);
        List<Integer> ages = users.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println("ages = " + ages);
        List<String> usernames = users.stream().map(User::getUsername).collect(Collectors.toCollection(Vector::new));
        System.out.println("usernames = " + usernames);
        TreeSet<String> genders = users.stream().map(User::getGender).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("genders = " + genders);
        IntSummaryStatistics ageStatistics = users.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println("ageStatistics = " + ageStatistics);
        Map<Boolean, List<User>> map = users.stream().collect(Collectors.partitioningBy(u -> u.getGender().equals("男")));
        System.out.println("map = " + map);
        Map<String, Long> map2 = users.stream().collect(Collectors.groupingBy(User::getGender,Collectors.counting()));
        System.out.println("map2 = " + map2);
        System.out.println("map2.keySet().size() = " + map2.keySet().size());
    }

    private static void initData(List<User> users) {
        Random random = new Random();
        char[] names1 = "赵钱孙李周吴郑王".toCharArray();
        char[] names2 = "春江潮水连海平".toCharArray();
        char[] names3 = "月落乌啼霜满天".toCharArray();

        for (int i = 0; i < 20; i++) {
            User u = new User();
            u.setAge(random.nextInt(100));
            u.setUsername(String.valueOf(names1[random.nextInt(names1.length)]) + names2[random.nextInt(names2.length)] + names3[random.nextInt(names3.length)]);
            u.setGender(random.nextInt(100) % 2 == 0 ? "男" : "女");
            users.add(u);
        }
    }
}
