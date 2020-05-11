package io.github.hank.java.concurrent.n3;

import io.github.hank.java.concurrent.Constants;
import io.github.hank.java.concurrent.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestStart")
public class TestStart {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug(Thread.currentThread().getName());
                FileReader.read(Constants.MP4_FULL_PATH);
            }
        };

        t1.start();
        log.debug("do other things ...");
    }
}
