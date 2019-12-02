package com.atguigu.Interview.study.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try {
            // 1. 判断
            while (num != 0){
                // 2. 等待，不能生产
                condition.await();

            }
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            // 3. 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void subtraction(){
        lock.lock();
        try {
            // 1. 判断
            while (num == 0){
                // 2. 等待，不能生产
                condition.await();

            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            // 3. 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * Created on 2019/11/29
 *
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 *
 * 1. 线程  操作  资源类
 * 2. 判断  干活  通知
 * 3. 防止虚假唤醒机制
 *
 * @author connor.chen
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }, "AAA").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    shareData.subtraction();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }, "BBB").start();
        }
    }
}
