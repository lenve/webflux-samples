package org.javaboy.webflux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class LambdaDemo04 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "里斯", "张五");
        List<String> list = names.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());
        for (String s : list) {
            System.out.println("s = " + s);
        }
        names.stream().forEach(s -> System.out.println(s));



        Supplier<Connection> supplier = ()->{
            Connection con = null;
            try {
                con = DriverManager.getConnection("", "", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        };
        Connection connection = supplier.get();
    }
}
