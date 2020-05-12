package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestFrames")
public class TestFrames {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> method1(20));
        t1.setName("t1");
        t1.start();
        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
        log.debug("Thread {} is running", Thread.currentThread().getName());
    }

    private static Object method2() {
        Object n = new Object();
        log.debug("Thread {} is running", Thread.currentThread().getName());
        return n;
    }
}
