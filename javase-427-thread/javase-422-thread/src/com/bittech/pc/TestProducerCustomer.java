package com.bittech.pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/4/27
 */
public class TestProducerCustomer {
    
    public static void main(String[] args) {
        //容器  file ,db , kafka, redis, mq , zookeeper
        final Queue<Goods> queue = new LinkedList<>();
        //生产者的业务类
        final Runnable produce = new Producer(queue);
        //消费者的业务类
        final Runnable customer = new Customer(queue);
        
        //生产者线程
        for (int i = 0; i < 5; i++) {
            new Thread(produce, "Thread-Produce-" + i).start();
        }
        //消费者线程
        for (int i = 0; i < 8; i++) {
            new Thread(customer, "Thread-Customer-" + i).start();
        }
    }
}
