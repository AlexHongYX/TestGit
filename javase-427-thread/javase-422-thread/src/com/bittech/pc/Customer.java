package com.bittech.pc;

import java.util.Queue;

/**
 * 消费者：
 * 1. 消费商品
 * 2. 从容器中取出商品
 * 3. 如果容器为空，通知生产者生产
 * <p>
 * Author: secondriver
 * Created: 2019/4/27
 */
public class Customer implements Runnable {
    private final Queue<Goods> queue;
    
    public Customer(Queue<Goods> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this.queue) {
                if (this.queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 容器已空 通知生产");
                    this.queue.notifyAll();
                } else {
                    Goods goods = this.queue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread().getName() + "  消费商品  " + goods);
                    }
                }
            }
        }
    }
}
