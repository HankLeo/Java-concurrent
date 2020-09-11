package io.github.hank.java.concurrent.n3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.ThreadStarter")
public class CreateThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1 - 直接创建Thread对象
        // 构造方法的参数是给线程指定名字，推荐
        Thread t1 = new Thread("t1") {
            @Override
            // run 方法内实现了要执行的任务
            public void run() {
                log.debug("hello");
            }
        };
        t1.start();

        // 2 - 创建Runnable任务对象，作为Thread构造函数的参数
        // 适用于无需拿到线程任务的返回值
        // 创建任务对象
        Runnable task2 = () -> log.debug("hello");
        // 参数1 是任务对象; 参数2 是线程名字，推荐
        Thread t2 = new Thread(task2, "t2");
        t2.start();

        // 3 - 创建FutureTask（Runnable的超类）任务对象
        // 适用于需要拿到其他线程任务的返回结果 - task.get()
        // 创建Callable对象作为FutureTask构造函数的参数
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.debug("hello");
            return 100;
        });
        // 参数1 是任务对象; 参数2 是线程名字，推荐
        new Thread(task3, "t3").start();
        // 主线程阻塞，同步等待 task 执行完毕的结果
        Integer result = task3.get();
        log.debug("结果是:{}", result);

        /**
         * Thread对象的start()方法被调用时，会唤起一个新的线程，而非在new Thread对象时；
         * 之后Thread对象的run()方法将在新创建的线程中被调用
         *
         * 方法1 - 直接使用重写run()方法；
         * 方法2 - Thread.run()会调用Runnable任务对象的run()方法；
         * 方法3 - Thread调用Runnable（此时是超类FutureTask）的run()方法，
         *         而FutureTask的run()方法会调用其callable成员变量的call()方法，
         *         之后FutureTask对象的get()方法能拿到call()方法的返回值。
         */
    }
}
