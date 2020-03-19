package com.xch.test;

import java.util.Arrays;

/**
 * @author xiech
 * @create 2020-03-04 10:51
 */
public class Test001 {
    public static void main(String[] args) {
        Object [] objects={1,2};
        System.out.println(objects.length);
        Object[] newObjects = Arrays.copyOf(objects, 10);
        System.out.println(newObjects.length);
        int[] fun={0,1,2,3,4,5,6};

        System.arraycopy(fun,0,fun,3,3);
        for (int i : fun) {
            System.out.print(i);
        }
    }
}
