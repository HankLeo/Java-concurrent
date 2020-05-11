package io.github.hank.java.concurrent.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.ThreadWatcher_Jconsole")
public class ThreadWatcher_Jconsole {
    public static void main(String[] args) {
        new Thread(() -> {
            while(true) {
                log.debug("running...");
            }
        }, "t1").start();

        new Thread(() -> {
            while(true) {
                log.debug("running...");
            }
        }, "t2").start();
    }
}
