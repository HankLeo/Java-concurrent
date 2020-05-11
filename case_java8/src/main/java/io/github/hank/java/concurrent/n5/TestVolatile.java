package io.github.hank.java.concurrent.n5;

public class TestVolatile {

    volatile boolean initialized = false;

    void init() {
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {

    }
}
