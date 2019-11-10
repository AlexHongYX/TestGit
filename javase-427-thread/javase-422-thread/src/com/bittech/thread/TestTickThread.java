package com.bittech.thread;

/**
 * 通过多线程卖票的例子引出同步问题
 * <p>
 * Author: secondriver
 * Created: 2019/4/24
 */
public class TestTickThread {
    
    public static void main(String[] args) {
        Runnable runnable = new MyTick2Runnable();
        new Thread(runnable, "Thread-黄牛A").start();
        new Thread(runnable, "Thread-黄牛B").start();
        new Thread(runnable, "Thread-黄牛C").start();
        
    }
}


class MyTickRunnable implements Runnable {
    
    private int tick = 10;
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            //--this.tick
            //this.tick-1
            //this.tick = this.tick-1
            //this.tick
            //多线程现在共享Runnable
            //this
            //Object object = new Object()
            //String.class
            synchronized(this) {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + " 买票， 剩余 " + (--this.tick));
                }
            }
        }
    }
}


class MyTick2Runnable implements Runnable {
    
    private int tick = 10;
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //A -> lock -> unlock ->lock -> unlock
            //A -> lock -> unlock -> 阻塞 -> 就绪 ->
            this.sale();
        }
    }
    
    //sale方法是MyTick2Runnable对象的方法，给对象加锁
    public synchronized void sale() {
        if (this.tick > 0) {
            System.out.println(Thread.currentThread().getName() + " 买票， 剩余 " + (--this.tick));
        }
    }
    
    //静态方法属于类的
    //类 Class
    //Class对象
    
    //MyTick2Runnable.print
    //Class<MyTick2Runnable> classz
    //MyTick2Runnable.class对象加锁
    public synchronized static void print(){
    
    }
}