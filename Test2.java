package com.fehead.pairtest;

import java.util.ArrayList;
import java.util.Collection;

public class Test2 {

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for(T t:a){
            c.add(t);
        }
    }

    public static void main(String[] args){
        Object[] oa =new Object[100];
        Collection<Object> co = new ArrayList<>();
        Test2.<Object>fromArrayToCollection(oa,co);
    }
}
