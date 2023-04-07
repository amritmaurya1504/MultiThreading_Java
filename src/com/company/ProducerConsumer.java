package com.company;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore empty = new Semaphore(BUFFER_SIZE);
    private final Semaphore full = new Semaphore(0);
    private final int[] buffer = new int[BUFFER_SIZE];
    private int in = 0, out = 0;

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread producerThread = new Thread(() -> {
            try {
                while (true) {
                    pc.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    pc.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producerThread.start();
        consumerThread.start();
    }

    public void produce() throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        int item = produceItem();
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        System.out.println("Produced item " + item);
        mutex.release();
        full.release();
        Thread.sleep(1000); // Wait for some time before producing the next item
    }

    public void consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        System.out.println("Consumed item " + item);
        mutex.release();
        empty.release();
        Thread.sleep(1000); // Wait for some time before consuming the next item
    }

    private int produceItem() {
        // Generate a new item
        return (int) (Math.random() * 10);
    }
}

