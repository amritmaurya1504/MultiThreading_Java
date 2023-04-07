package com.company;

/* If we run this program we didn't get 2000 as count due to thread running
* paralley so one way of dealing with that is to add synchronized key word in
* function increament then it will make it run one thread at a time. */

class Counter{
    int count = 0;
    public synchronized void inCreament(){
        count++;
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    c.inCreament();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    c.inCreament();
                }
            }
        });

        t1.start();
        t2.start();

        t2.join();
        t1.join(); // if t1 completes then count print

        System.out.println("Count -> " + c.count);

    }
}
