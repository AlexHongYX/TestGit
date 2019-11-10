package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/27
 */
public class TestLock {

//    public static StringBuffer sb = new StringBuffer();

//    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        //1加锁，1次释放锁
        
        //锁的消除
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
    }
}
