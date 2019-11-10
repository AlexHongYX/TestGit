package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/27
 */
public class TestRepeatThread {
    
    public static final Object lock = new Object();
    
    /*  什么时候才会对lock完全释放？
        xxxx
        monitorenter
            monitorenter
                monitorenter
                    ....
                monitorexit
            monitorexit
        monitorexit
        xxxx
     */
    /*
         xxxx
         object.lock
            xxxx
            xxxx
         object.unlock
         
         object.lock
         try{
            //进行同步的代码
         }finally{
           object.unlock
         }
     */
    public static void test() {
        System.out.println("开始test");
        synchronized(lock) {
            System.out.println("此处执行1000行代码");
            synchronized(lock) {
                System.out.println("此处执行1000行代码");
            }
        }
        System.out.println("结束test");
    }
}
