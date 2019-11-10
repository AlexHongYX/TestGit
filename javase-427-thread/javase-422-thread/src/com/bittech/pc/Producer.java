package com.bittech.pc;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者：
 * 1. 生产商品
 * 2. 将生产的商品添加到容器
 * 3. 如果容器已经满了，等待消费（等通知）
 * Author: secondriver
 * Created: 2019/4/27
 */
public class Producer implements Runnable {
    
    private final Queue<Goods> queue;
    
    private final Integer maxCapacity = 10;
    
    //原子变量
    private final AtomicInteger id = new AtomicInteger(0);
    
    public Producer(Queue<Goods> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this.queue) {
                if (this.queue.size() == maxCapacity) {
                    //wait
                    System.out.println(Thread.currentThread().getName() + " 容器满了  等待消费");
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods = new Goods(
                            String.valueOf(id.getAndIncrement()),
                            "商品"
                    );
                    System.out.println(Thread.currentThread().getName() + " 生产商品 " + goods);
                    this.queue.add(goods);
                }
            }
        }
    }
}
