package com.bittech.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author: secondriver
 * Created: 2019/4/22
 */
public class TestCallable {
    
    public static void main(String[] args) {
        //业务对象
        Callable<String> callable = new MyCallable();
        
        //将来的任务
        //Runnable  ->  futureTask
        FutureTask<String> futureTask = new FutureTask<>(callable);
        
        Thread thread = new Thread(futureTask);
        thread.start();
        
        System.out.println("main 代码");
        System.out.println("main 代码");
        System.out.println("main 代码");
        
        try {
            //阻塞方法 获取线程执行的结果
            String string = futureTask.get();
            System.out.println(string);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }
}


class MyCallable implements Callable<String> {
    private int tick = 10;
    
    @Override
    public String call() throws Exception {
        while (this.tick > 0) {
            System.out.println("剩余：" + --this.tick + " 票");
        }
        return "票卖完啦";
    }
}