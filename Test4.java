package com.fehead.pairtest;

import java.lang.Comparable;

public class Test4 {
        public static <T extends Comparable<T>> int countGreater(T[] array,T elem){         //只能比较基本数据类型
            int count = 0;                                                                //不能比较类对象之间的大小
            for(T t:array) {
                if (t.compareTo(elem) > 0) {
                    ++count;
                }
            }
            return count;
    }

    public static void main(String[] args){
        Integer[] array = new Integer[10];
        for(int i=0;i< args.length;i++){
            array[i] = i;
        }
        int elem = 1;
        int count;
        count = Test4.<Integer>countGreater(array,elem);
        System.out.println(count);
    }
}
