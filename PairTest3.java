package com.fehead.pair3;

import com.fehead.company.ManagerText;

public class PairTest3 {
    public static void main(String[] args){
        MyManager ceo = new MyManager("Gus Greedy",800000,2003,12,15);
        MyManager cfo = new MyManager("Sid Sneaky",600000,2003,12,15);
        Pair<MyManager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        MyManager[] managers = {ceo,cfo};

        Pair<MyEmployee> result = new Pair<>();
        minmaxBonus(managers,result);
        System.out.println("first: " + result.getFirst().getName() + "second: " + result.getSecond().getName());
        maxminBonus(managers,result);
        System.out.println("first: " + result.getFirst().getName() + "second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends MyEmployee> p){
        MyEmployee first = p.getFirst();
        MyEmployee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(MyManager[] a,Pair<? super MyManager> result){
        if(a.length ==0) return;
        MyManager min = a[0];
        MyManager max = a[0];
        for(int i=1;i<a.length;i++){
            if(min.getBonus() > a[i].getBonus()) min = a[i];
            if(max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(MyManager[] a,Pair<? super MyManager> result){
        minmaxBonus(a,result);
        PairAlg.swapHelper(result);     //OK--swapHelper captures wildcard type
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst()==null || p.getSecond()==null;
    }

    public static void swap(Pair<?> p){
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
