package com.xch.ext;


import java.util.LinkedList;

/**
 *
 * 数组加链表实现hashMap
 * @author xiech
 * @create 2020-04-03 10:48
 */
public class ExtLinkedListMap<K,V> {

    private LinkedList<Entry<K,V>>[] tables=new LinkedList[998];

    private int  size;

    /**
     * 存放
     * @param key
     * @param value
     */
    public void put(K key,V value){
        Entry entry=new Entry(key,value);
        int hash=getHash(key);
        //判断该hash是否在数组中存在
        LinkedList<Entry<K,V>> linkedList=tables[hash];
        if(linkedList==null){
            //不存在 创建新的链表
            LinkedList<Entry<K,V>> newList=new LinkedList<>();
            newList.add(entry);
            tables[hash]=newList;
        }else{
            //存在hash冲突  判断hashCode是否相同
            for (Entry oldEntry : linkedList) {
                if(oldEntry.key.equals(key)){
                    //说明Key相同进行value覆盖
                    oldEntry.value=value;
                }else{
                    linkedList.add(entry);
                }
            }

        }
        size++;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public V get(K key){
        return getEntry(key).value;
    }

    /**
     * 获取entry
     * @param key
     * @return
     */
    public Entry<K,V> getEntry(K key){
      int hash=getHash(key);
      //根据hash获取链表
      LinkedList<Entry<K,V>> linkedList=tables[hash];
      //链表存在  获取链表中值
      if(linkedList!=null){
          for (Entry<K, V> entry : linkedList) {
              if(entry.key.equals(key)){
                  return entry;
              }
          }
      }
      return null;
    }

    /**
     * 删除
     * @param key
     */
    public void remove(K key){
        int hash=getHash(key);
        //根据hash获取链表
        LinkedList<Entry<K,V>> linkedList=tables[hash];
        //链表存在  获取链表中值
        if(linkedList!=null){
            for (Entry<K, V> entry : linkedList) {
                if(entry.key.equals(key)){
                    linkedList.remove(entry);
                }
            }
        }
    }

    public int size(){
        return size;
    }

    /**
     * 获取hash算法值
     * @param key
     * @return
     */
    public int getHash(K key) {
        int hashCode=key.hashCode();
        int hash=hashCode % 3;
        return hash;
    }

    /**
     * 元素对象
     * @param <K>
     * @param <V>
     */
    class Entry<K,V>{
       K key;
       V value;

       public Entry(K key, V value) {
           this.key = key;
           this.value = value;
       }
   }

    public static void main(String[] args) {
        ExtLinkedListMap<String,String> map=new ExtLinkedListMap<>();
        map.put("a","aaaa");
        map.put("b","bbbb");
        map.put("c","cccc");
        map.put("d","dddd");
        map.put("e","eeee");
        System.out.println(map.get("d"));
    }
}
