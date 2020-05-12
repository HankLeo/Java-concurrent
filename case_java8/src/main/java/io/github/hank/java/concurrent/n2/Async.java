package io.github.hank.java.concurrent.n2;

import io.github.hank.java.concurrent.Constants;
import io.github.hank.java.concurrent.n2.util.FileReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "c.Async")
public class Async {

    public static void main(String[] args) {
        new Thread(() -> FileReader.read(Constants.JPG_FULL_PATH), "t1").start();
        log.debug("do other things ...");
    }

}
