package io.github.hank.java.concurrent.n3;

import io.github.hank.java.concurrent.n2.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static io.github.hank.java.concurrent.n2.util.Sleeper.sleep;

@Slf4j(topic = "c.TestInterrupt")
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }
    private static void test4() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log.debug("park...");  // for循环可以在下个迭代中再次park
                LockSupport.park();
                log.debug("打断状态：{}", Thread.interrupted());
            }
        });
        t1.start();


        Sleeper.sleep(1);
        t1.interrupt();
    }
    private static void test3() {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());

            LockSupport.park();
            log.debug("cannot be parked again...");
        }, "t1");
        t1.start();


        Sleeper.sleep(0.5);
        t1.interrupt();
    }
    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                log.debug(" Thread.interrupted: {}", Thread.interrupted());
                if(interrupted) {
                    log.debug(" 打断状态: {}", true);
                    break;
                }
            }
        }, "t2");
        t2.start();

        Sleeper.sleep(0.1);
        t2.interrupt();
    }
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            Sleeper.sleep(1);
            log.debug(" Thread.interrupted: {}", Thread.interrupted());
        }, "t1");
        t1.start();

        Sleeper.sleep(0.5);
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());  // isInterrupted vs interrupted when thread state is sleep
    }
}
