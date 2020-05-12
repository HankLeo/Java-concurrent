package io.github.hank.java.concurrent.n3;

import io.github.hank.java.concurrent.Constants;
import io.github.hank.java.concurrent.n2.util.FileReader;

public class TestState2 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            FileReader.read(Constants.JPG_FULL_PATH);
            FileReader.read(Constants.JPG_FULL_PATH);
            FileReader.read(Constants.JPG_FULL_PATH);
        }, "t1").start();

        Thread.sleep(1000);
        System.out.println("ok");
    }
}
