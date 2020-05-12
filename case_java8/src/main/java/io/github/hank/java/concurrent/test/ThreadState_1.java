package io.github.hank.java.concurrent.test;

import io.github.hank.java.concurrent.Constants;
import io.github.hank.java.concurrent.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.ThreadState_1")
public class ThreadState_1 {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("running...");
                FileReader.read(Constants.JPG_FULL_PATH);
            }
        };

        t1.start();
        log.debug("do other things...");
    }
}
