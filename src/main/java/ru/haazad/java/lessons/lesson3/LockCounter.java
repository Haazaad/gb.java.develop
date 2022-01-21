package ru.haazad.java.lessons.lesson3;


import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockCounter {
    private static final int RANGE_COUNT = 10;

    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService service = Executors.newFixedThreadPool(RANGE_COUNT);
        IntStream.range(0, RANGE_COUNT).forEach(a -> service.submit(counter.increase()));
        service.shutdown();
    }

    static class Counter {
        @Getter private Integer count;
        private Lock lock;

        public Counter() {
            count = 0;
            lock = new ReentrantLock();
        }

        public Runnable increase() {
            return () -> {
                try {
                    if (lock.tryLock(1, TimeUnit.MILLISECONDS)) {
                        count++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            };
        }
    }
}
