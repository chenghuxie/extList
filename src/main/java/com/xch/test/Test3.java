package com.xch.test;

import java.util.LinkedList;

/**
 * @author xiech
 * @create 2020-04-02 11:07
 */
public class Test3 {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add(1,"c");
        list.remove("a");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
