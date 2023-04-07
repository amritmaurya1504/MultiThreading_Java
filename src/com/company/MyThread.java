package com.company;

// Creating our thread using Runnable Interface
public class MyThread implements Runnable {
    public void run(){
        // Task for thread;
        for (int i = 1; i <=10; i++) {
            System.out.println("Value of i is " + i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        // Create object of MyThread class
        MyThread t1 = new MyThread();
        Thread thr1 = new Thread(t1);
        // Object of another thread
        MyAnotherThread t2 = new MyAnotherThread();
        t2.start();
        thr1.start();

    }
}
