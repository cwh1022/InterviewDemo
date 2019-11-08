package com.atguigu.Interview.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created on 2019/11/8
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源都应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源了，就不应该再有其他线程可以对该资源进行读或写
 * 小总结：
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *
 * @author connor.chen
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEachIndex(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ************秦帝国，一统华夏");
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        /*while (Thread.activeCount() > 2){
            Thread.yield();
        }*/
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t ************最后关门走人");
    }
}
