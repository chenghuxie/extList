package com.xch.ext;

import java.util.Arrays;

/**
 * @author xiech
 * @create 2020-03-06 10:20
 */
public class ExtArrayList {
    // 保存ArrayList中数据的数组
    private  Object[] elementData;

    // ArrayList实际数量
    private int size;

    public ExtArrayList(){
        this(10);
    }

    /**
     * initialCapacity  初始容量
     * @param initialCapacity
     */
    public ExtArrayList(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elementData=new Object[initialCapacity];
    }

    /**
     * 添加元素
     * @param object
     */
    public void add(Object object){
        /**
         *扩容以确保数字容量充足
         */
        ensureExplicitCapacity(size + 1);
        elementData[size++]=object;
    }

    public void add(int index,Object object){
        /**
         * 校验角标
         */
        rangeCheck(index);
        ensureExplicitCapacity(size+1);
        /**
         * 将角标index以后的数组整体后移
         */
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        //赋值
        elementData[index]=object;
        //长度++
        size++;
    }

    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    public Object remove(int index){
        Object object=get(index);
        int numMoved=elementData.length-index-1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[size--]=null;
        return object;
    }

    /**
     * 获取集合长度
     * @return
     */
    public int getSize(){
        return size;
    }


    private void rangeCheck(int index) {
        if(index>=size){
            throw new IndexOutOfBoundsException("角标越界!");
        }
        if(index<0){
            throw new IndexOutOfBoundsException("数组下标不能小于0!");
        }
    }


    /**
     * 扩容以确保数字容量充足
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        // 如果存入的数据,超出了默认数组初始容量 就开始实现扩容
       if(size==elementData.length){
           int  oldCapacity=elementData.length;
           // oldCapacity >> 1 理解成 oldCapacity/2 新数组的长度是原来长度1.5倍
           int newCapacity=oldCapacity+(oldCapacity>>1);
           if(newCapacity< minCapacity){
             newCapacity=minCapacity;
           }
           elementData=Arrays.copyOf(elementData,newCapacity);
       }
    }


}
