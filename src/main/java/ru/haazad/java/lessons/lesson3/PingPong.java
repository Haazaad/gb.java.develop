package ru.haazad.java.lessons.lesson3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PingPong {
    private static final int RANGE_COUNT = 10;
    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < RANGE_COUNT; i++) {
            service.submit(create("ping"));
            SEMAPHORE.release();
            service.submit(create("pong"));
            SEMAPHORE.release();
        }
        service.shutdown();
    }

    private static Runnable create(String s) {
        return () -> {
            try {
                SEMAPHORE.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        };
    }

}
