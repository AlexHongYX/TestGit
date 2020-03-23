package com.fehead.pairtest;

public class Test1<T>{
    T obj;

    public T getObj(){
        return obj

    public void setObj(T obj){
        this.obj = obj;
    }

    public static void main(String[] args){
        Test1<String> gen = new Test1<>();
        gen.setObj("abc");
        //gen.setObj(10);
        String str = gen.getObj();
        System.out.println(str);
        //---------------
        Test1 gen2 = new Test1();
        gen2.setObj("abc");
        String str1 = (String)gen2.getOb
        System.out.println(str1);
        Test1 gen3 = new Test1();
        gen3.setObj(10);
        Integer num = (Integer)gen3.getObj();
        System.out.println(num);
    }
}
