package com.atguigu.Interview.study.ref;

import java.lang.ref.WeakReference;

/**
 * Created on 2019/12/6
 *
 * @author connor.chen
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference);

        o1 = null;
        System.gc();
        System.out.println("=====================");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
