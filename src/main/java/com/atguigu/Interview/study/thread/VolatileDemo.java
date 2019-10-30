package com.atguigu.Interview.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/10/30
 *
 * @author connor.chen
 */
class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
}

/**
 * 1. 验证volatile的可见性
 *  1.1 假如int number = 0；number变量之前根本没有添加volatile关键字修饰
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        }, "AAA").start();
        while (myData.number == 0){
            // main线程一直在这里等待循环，直到number值不再等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get value is:" + myData.number);
    }
}
