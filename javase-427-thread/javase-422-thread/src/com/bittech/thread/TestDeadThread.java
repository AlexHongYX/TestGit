package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/27
 */
public class TestDeadThread {
    
    
    public static void main(String[] args) {
        
        Pen pen = new Pen();
        Book book = new Book();
        
        //线程A
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(pen) {
                    System.out.println(Thread.currentThread().getName() + " 我有笔，没有本");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(book) {
                        System.out.println(Thread.currentThread().getName() + " 我有笔，有本");
                    }
                }
            }
        }, "Thread-A").start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(book) {
                    System.out.println(Thread.currentThread().getName() + " 我有本，没有笔");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(pen) {
                        System.out.println(Thread.currentThread().getName() + " 我有本，有笔");
                    }
                }
            }
        }, "Thread-B").start();
    }
}


class Pen {

}

class Book {

}

