package com.xch.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiech
 * @create 2020-04-02 17:22
 */
public class ExtArrayListHashMap<K,V> {
    
    List<Entry<K,V>> tables=new ArrayList<>();

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void put(K key,V value){
        //判断key是否存在
        Entry existEntry=getEntry(key);
        //存在替换value值
        if(existEntry!=null){
            existEntry.value=value;
            return;
        }
        //不存在创建新元素
        Entry entry=new Entry<K,V>(key,value);
        //将元素放入集合中
        tables.add(entry);
    }

    /**
     * 根据key获取元素
     * @param key
     * @return
     */
    public Entry<K,V> getEntry(K key) {
        for (Entry<K, V> entry : tables) {
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    /**
     * 删除元素
     * @param key
     */
    public void remove(K key){
        //判断key是否存在
        Entry existEntry=getEntry(key);
        //存在替换value值
        if(existEntry!=null){
           tables.remove(existEntry);
        }
    }

    public Entry<K,V> get(K key){
        for (Entry<K, V> entry : tables) {
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ExtArrayListHashMap<String,String> map=new ExtArrayListHashMap<>();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("a","aaaa");
        map.remove("a");
        System.out.println(map.get("a").value);
    }

    class Entry<K,V>{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
