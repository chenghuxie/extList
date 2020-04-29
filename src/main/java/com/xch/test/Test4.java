package com.xch.test;

import com.xch.ext.ExtLinkedList;

/**
 * @author xiech
 * @create 2020-04-02 15:31
 */
public class Test4 {
    public static void main(String[] args) {
        ExtLinkedList<String> linkedList=new ExtLinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add(1,"d");
        for (int i=0;i<linkedList.size();i++ ) {
            System.out.println(linkedList.get(i));



        }
    }
}
