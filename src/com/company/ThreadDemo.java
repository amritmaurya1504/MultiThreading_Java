package com.company;

class Hi extends Thread{
    public void run(){
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Hi");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Hello extends Thread{
    public void run(){
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Hello");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Hey implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Hey");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Hurray implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            System.out.println("Hurray");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();
        // With Thread
        // obj1.start();
        //obj2.start();

       /* Without Thrad*/
        // obj1.show();
        // obj2.show();

        // Using RUNNABLE Interface
        /*
        Hey obj3 = new Hey();
        Hurray obj4 = new Hurray();

        Thread t1 = new Thread(obj3);
        Thread t2 = new Thread(obj4);

        t1.start();
        t2.start();
         */


        // Another way of making Threads (Anonymous Class)
        Runnable obj5 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=5 ; i++) {
                    System.out.println("Through Runnable Method!");
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }
        };

        Runnable obj6 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <=5 ; i++) {
                    System.out.println("Through Runnable Method! 2");
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }
        };
        Thread t1 = new Thread(obj5);
        Thread t2 = new Thread(obj6);

        // t1.start();
        // t2.start();

        // USING LAMBDA EXPRESSION
        Runnable obj7 = () -> {
                for (int i = 0; i <=5 ; i++) {
                    System.out.println("Through Lambda 1");
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            };

        Runnable obj8 = () -> {
                for (int i = 0; i <=5 ; i++) {
                    System.out.println("Through Lambda 2");
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            };

        Thread t3 = new Thread(obj7);
        Thread t4 = new Thread(obj8);
        // Another Method
        Thread t5 = new Thread(() -> {
            for (int i = 0; i <=5 ; i++) {
                System.out.println("Through Direct");
                try { Thread.sleep(1000); } catch (Exception e) {}
            }
        });

        System.out.println(t3.getPriority());
        t3.setPriority(1);
        t3.setPriority(Thread.MAX_PRIORITY);

        t3.start();
        try { Thread.sleep(1000); } catch (Exception e) {}
        t4.start();
       // try { Thread.sleep(1000); } catch (Exception e) {}
       // t5.start();


        t3.join();
        t4.join();
        t5.join();

        System.out.println(t3.isAlive());
        System.out.println("Bye");
    }
}
