package com.company;

//Creating thread using thread class

public class MyAnotherThread extends Thread{
    public void run(){
        for (int i = 10; i >=1 ; i--) {
            System.out.println("Value of another thread i is " + i);
            try{
                Thread.sleep(2000);
            }catch (Exception e){}
        }
    }

}
