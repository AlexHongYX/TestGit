package com.fehead.thread.test;

//start():启动一个新的线程，新线程会执行相应的run()方法。start()不能被重复调用
//run():run()就和普通成员方法一样，可以被重复调用。
//单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程

public class ThreadTest3 {
    public static void main(String[] args){
        Thread mythread = new MyThread3("mythread");
        //Thread.currentThread().getName()是用于获取“当前线程”的名字。
        //当前线程是指在cpu中调度执行的过程
        System.out.println(Thread.currentThread().getName()+" call mythread.run()");
        //mythread.run()是在“主线程main”中调用的，该run()方法直接运行在“主线程main”上
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        //mythread.start()会启动“线程mythread”，“线程mythread”启动之后，
        //会调用run()方法，此时的run()方法是运行在“线程mythread”上
        mythread.start();
    }
}

class MyThread3 extends Thread{
    public MyThread3(String name){
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
