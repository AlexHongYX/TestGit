package com.bittech.thread;

import java.lang.ref.WeakReference;

/*
ThreadLocal:
1. 创建线程独享的变量
2. ThreadLocal.withInitial()获取具有默认值的ThreadLocal对象

如果多线程访问同一个变量，不希望相互干扰：
1. 在使用变量的时候，在线程中创建变量的副本进行使用
2. 使用ThreadLocal对象

引用方式：
1. 强引用

2. 软引用
3. 弱引用
4. 虚幻引用（幽灵引用）

 */
public class TestThreadLocal {

//    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    private static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(() -> "默认值");
    
    private static String strValue;
    
    public static void code1() {
        //main线程
        strValue = "main线程修改";
        threadLocal.set("main线程修改");
        new Thread(new Runnable() {
            @Override
            public void run() {
                strValue = "Thread-A修改";
//                threadLocal.set("Thread-A修改");
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            }
        }, "Thread-A").start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //main线程获取值
        //main,Thread-A 同时访问strValue , threadLocal
        System.out.println(strValue);
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
    
    public static void main(String[] args) {
        String abc = new String("abc");
        WeakReference<String> weakReference = new WeakReference<>(abc);
        System.out.println(weakReference.get());
    }
}
