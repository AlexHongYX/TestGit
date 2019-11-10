package com.bittech.method;

/**
 * Author: secondriver
 * Created: 2019/4/22
 */
public class TestThreadName {
    
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            new MyThreadName("MyThread-" + i).start();//启动线程
//        }
//        Thread thread = new MyThreadName("Thread-Print");
////        thread.setName("Thread-Print");
//        thread.start();
        
        
        Thread thread = new Thread(() -> {
            // 1 + 2 + .. + n
            //sum  = (n+1)*n/2
            int n = 100;
            int sum = (n + 1) * n / 2;
            System.out.println(Thread.currentThread().getName() + " 计算结果 " + sum);
            
        }, "Thread-Compute-高斯函数");
        thread.start();
        
        //main
        //Java (JVM) 进程
        //创建一个线程作为程序入口，主线程，名称main
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        
        
    }
}

class MyThreadName extends Thread {
    
    public MyThreadName(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //获取当前线程
            Thread thread = Thread.currentThread();
            //获取当前线程名称
            String name = thread.getName();
            System.out.println(name + " " + i);
        }
    }
}

