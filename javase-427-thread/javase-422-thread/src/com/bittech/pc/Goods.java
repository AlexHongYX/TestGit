package com.bittech.pc;

/**
 * 生产者生产商品类
 * <p>
 * Author: secondriver
 * Created: 2019/4/27
 */
public class Goods {
    
    private final String id;
    
    private final String name;
    
    public Goods(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
