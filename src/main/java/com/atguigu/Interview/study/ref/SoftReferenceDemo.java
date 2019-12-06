package com.atguigu.Interview.study.ref;

import java.lang.ref.SoftReference;

/**
 * Created on 2019/12/6
 *
 * @author connor.chen
 */
public class SoftReferenceDemo {
    /**
     * 内存够用的时候就保留，不够用就回收！
     */
    public static void softRef_Memory_Enough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让他内存不够用了导致OOM，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(new Object());
        System.out.println(softReference.get());
        System.out.println(o);
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(softReference.get());
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
