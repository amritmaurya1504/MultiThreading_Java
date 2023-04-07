## Creating Thread in Java
    1. Using Runnable Interace
    2. Using Thread Class

```
Inteface Runnable{
    Run(); // abstract method , what we want to do with thread
}

Class Thread{
    run();
}

THREAD CLASS EXTENDS -> Runable Interface
```

## Starting Thread in Java

```
class MyThread implements Runnable{
    public void run(){
        //task
    }
}

MyThread t = new MyThread();
Thread thread = new Thread(t);

thread.start();
```
## Thread Life Cycle

```
                   Active
            ---------------------
 1. New -> | Runnable -> Running | -> Terminated
            ---------------------
            
    if some thread have non runnable code then it will blocked 
    for some time after completed then it will go back to runnable 
    queue.
            Non Runnable (Blocked)
            ex:- sleep(), I/O
```

## Some Important Methods of Thread

```
    1. getName()
    2. setName()
    3. run()
    4. start()
    5. getId()
    6. setPriority(), getPriorirty()
    7. sleep(), join(), interrupt(), resume(), stop()... etc
```