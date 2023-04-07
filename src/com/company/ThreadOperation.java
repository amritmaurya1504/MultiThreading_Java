package com.company;

class UserThread extends Thread{
    public void run(){
        // Task for thread
        System.out.println("This is UserThread!");
    }
}

public class ThreadOperation {
    public static void main(String[] args) {
        System.out.println("Program Started...");
        int x = 56+35;
        System.out.println("sum is " + x);
        // Thread...
        // getName
        Thread t = Thread.currentThread(); // to get object of current thread
        System.out.println("Current Thread name : " + t.getName());
        // setName;
        t.setName("ThreadOne");
        System.out.println("Current Thread name : " + t.getName());
        System.out.println(t.getId());

        System.out.println("Program Ended...");

        // going to start user defined thread;
        UserThread ut = new UserThread();
        ut.start();

    }
}
