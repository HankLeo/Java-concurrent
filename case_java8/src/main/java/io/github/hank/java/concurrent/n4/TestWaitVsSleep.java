package io.github.hank.java.concurrent.n4;

import io.github.hank.java.concurrent.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.TestWaitVsSleep")
public class TestWaitVsSleep {

    private final static Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                log.debug("Get Lock");
                try {
                    log.debug("Pending...");
                    Thread.sleep(20000);    // sleep时不会释放锁
//                    lock.wait(20000);    // wait时会释放锁，线程进入waitSet，entrySet中的线程可以获得锁对象
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Sleeper.sleep(1);
        log.debug("State of t1: {}", t1.getState());    //TIMED_WAITING
        synchronized (lock) {
            log.debug("Get Lock");
        }
    }

}
