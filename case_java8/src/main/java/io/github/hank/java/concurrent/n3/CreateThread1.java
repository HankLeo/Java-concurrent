package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.CreateThread1")
public class CreateThread1 {

    public static void main(String[] args) {
        // 1 - 使用传入Runnable对象的构造函数
        // 线程（Thread）与任务（Runnable）分离
        Thread t1 = new Thread(() -> log.debug("running..."));
        t1.setName("t1");
        t1.start();

        // 2 - 直接创建Thread对象并重写Thread类的run方法
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                log.debug("running...");
            }
        };
        t2.start();

        log.debug("running...");
    }

}
