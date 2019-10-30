package com.atguigu.Interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

    /**
     * 请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性
     */
    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1. 验证volatile的可见性
 *  1.1 假如int number = 0；number变量之前根本没有添加volatile关键字修饰
 *  1.2 添加了volatile，可以解决可见性问题
 *
 * 2. 验证volatile不保证原子性
 *  2.1 原子性指的是什么意思？
 *      不可分割，也即每个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要整体完整
 *      要么同时成功，要么同时失败
 *  2.2 不保证原子性
 *  2.3 why
 *  2.4 如何解决原子性？
 *      * 加sync
 *      * 使用juc下面的AtomicInteger
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待20个线程全部计算完成后，再用main线程取得最终的结果值
        // 之所以是2，是因为Java中默认有两个线程，一个是main线程，另外一个gc线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomicInteger finally number value:" + myData.atomicInteger.get());
    }

    /**
     * volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
    public static void seeOkByVolatile(){
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
