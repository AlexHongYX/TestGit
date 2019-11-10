package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/27
 */
public class TestSyncThread {
    
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new MySyncThread(lock);
//            //Thread-Sync-0 .. Thread-Sync-9
//            //Sync   ...    Sync
//            //Sync.class -> 同一个ClassLoader Sync.class
//            thread.setName("Thread-Sync-" + i);
//            thread.start();
//        }

//        Sync sync = new Sync();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new MySyncThread2(sync);
//            thread.setName("Thread-Sync-" + i);
//            thread.start();
//        }
    
        final Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            Thread thread = new MySyncThread(lock);
            //Thread-Sync-0 .. Thread-Sync-9
            //Sync(lock)   ...    Sync(lock)
            //lock 同一个对象
            //Sync test lock(同步)
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }
        
    }
}

//线程安全的类
class Sync {
    
    //同步Sync对象的test方法
    //多线程同一时间访问同一个Sync对象的test方法时
    //会进行同步操作，只能同一时间有一个线程访问Sync对象的test方法
    /*
    public synchronized void test() {
        System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
    }
    */
    
    /*
    public void test() {
        synchronized(this) {
            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
        }
    }
     */
    
    //多线程同一时间访问Sync的test方法，方法中对Sync.class对象同步（加锁）-> 全局锁
//    public void test() {
//        synchronized(Sync.class) {//对Sync类的对象进行同步
//            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
//        }
//    }
    
    private final Object lock;
    
    Sync(Object lock) {
        this.lock = lock;
    }
    
    public void test() {
        synchronized(lock) {//对Sync类的对象进行同步
            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
        }
    }
}

class MySyncThread extends Thread {
    private final Object lock;
    
    MySyncThread(Object lock) {
        this.lock = lock;
    }
    
    @Override
    public void run() {
        Sync sync = new Sync(lock);
        sync.test();
    }
}

class MySyncThread2 extends Thread {
    private final Sync sync;
    
    MySyncThread2(Sync sync) {
        this.sync = sync;
    }
    
    @Override
    public void run() {
        sync.test();
    }
}