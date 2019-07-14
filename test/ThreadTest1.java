package com.fehead.thread.test;


//MyThread继承于Thread，它是自定义个线程。每个MyThread都会卖出10张票
//主线程main创建并启动3个MyThread子线程。每个子线程都各自卖出了10张票
public class ThreadTest1 {
    public static void main(String[] args){
        //启动3个线程t1，t2，t3，每个线程各卖10张票
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread1 extends Thread{
    private int ticket = 10;
    public void run(){
        for (int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票:ticket"+this.ticket--);
            }
        }
    }
}