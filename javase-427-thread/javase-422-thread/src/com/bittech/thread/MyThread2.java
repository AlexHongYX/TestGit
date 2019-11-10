package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/22
 */
public class MyThread2 {
    
    public static void code1() {
        Runnable runnable = new MyRunnable("MyRunnable");
        
        System.out.println("main开始");
        
        Thread myThread = new Thread(runnable);
        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);
        }
        System.out.println("main结束");
    }
    
    public static void code2(){
        System.out.println("main开始");
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("runnable " + i);
            }
        });
        myThread.start();//start()->start0()->run()->target.run()->runnable.run()
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);
        }
        System.out.println("main结束");
    }
    
    public static void code3(){
        System.out.println("main开始");
        Runnable runnable = new MyRunnable("MyRunnable");
    
        Thread myThread1 = new Thread(runnable);
        myThread1.start();
        Thread myThread2 = new Thread(runnable);
        myThread2.start();
    
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + i);
        }
        System.out.println("main结束");
    }
    
    public static void main(String[] args) {
        //第一种方式
        /*
        1. Thread 关联的是本地线程
        2. 实现了 Runnable接口  run()-> target.run()
         */
        Thread thread = new MyThread("My-Thread");
        thread.start();
        
        //1.Runnable     代理接口
        //2.MyRunnable implements Runnable  业务类
        //3.MyThread   implements Runnable
        //3.Thread     implements Runnable  代理类
        //  提供了一个类型是Runnable的属性以及构造方法
        
        //第二种方式
        /*
        1. MyRunnable 实现了Runnable
        2. Runnable的实现类的实例化对象
        3. new Thread(Runnable target)
         */
        Runnable runnable = new MyRunnable("MyRunnable");
        Thread myThread1 = new Thread(runnable);
        myThread1.start();
      
     
        
    }
}

class MyRunnable implements Runnable {
    
    private String title;
    
    MyRunnable(String title) {
        this.title = title;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}