package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.CreateThread2")
public class CreateThread2 {

    public static void main(String[] args) {
        Runnable r = () -> log.debug("running...");
        Thread t3 = new Thread(r, "t3");
        t3.start();

        log.debug("Main thread running...");
    }

}
