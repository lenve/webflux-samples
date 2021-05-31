package org.javaboy.flow;

import java.util.Scanner;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class FlowDemo {
    public static void main(String[] args) {

        class DataFilter extends SubmissionPublisher<String> implements Flow.Processor<String,String>{

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                this.submit("【这是一条被处理过的数据】" + item);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                this.close();
            }
        }

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        DataFilter dataFilter = new DataFilter();
        publisher.subscribe(dataFilter);

        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                //向数据发布者请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收到 publisher 发来的消息了：" + item);
                //接收完成后，可以继续接收或者不接收
                //this.subscription.cancel();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                //出现异常，就会来到这个方法，此时直接取消订阅即可
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                //发布者的所有数据都被接收，并且发布者已经关闭
                System.out.println("数据接收完毕");
            }
        };
        dataFilter.subscribe(subscriber);
        for (int i = 0; i < 500; i++) {
            System.out.println("发送消息 i--------->" + i);
            publisher.submit("hello:" + i);
        }
        //关闭发布者
        publisher.close();
        new Scanner(System.in).next();
    }
}
