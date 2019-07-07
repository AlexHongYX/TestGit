package com.fehead.pair3;

public class Pair<String> {
    private String first;
    private String second;


    public Pair(){
        first = null;
        second = null;
    }

    public Pair(String first, String second){
        this.first = first;
        this.second = second;
    }


    public String getFirst(){
        return first;
    }

    public String getSecond(){
        return second;
    }


    public void setFirst(String newValue){
        first = newValue;
    }

    public void setSecond(String newValue){
        second = newValue;
    }
}
