package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestJconsole")
public class TestJconsole {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.debug("running...");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("running...");
            }
        }, "t2").start();

        while (true) {
            log.debug("Main thread is running...");
        }
    }

}
