package com.atguigu.Interview.study.ref;

/**
 * Created on 2019/12/6
 *
 * @author connor.chen
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();//这样定义的默认就是强引用
        Object o2 = o1;//o2引用赋值
        o1 = null;
        System.gc();
        System.out.println(o2);

    }
}
