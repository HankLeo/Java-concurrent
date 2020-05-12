package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.CreateThread1")
public class CreateThread1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> log.debug("running..."));
        t1.setName("t1");
        t1.start();

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
