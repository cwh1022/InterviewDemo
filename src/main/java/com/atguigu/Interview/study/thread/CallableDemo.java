package com.atguigu.Interview.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tcome in callable");
        return 1024;
    }
}
/**
 * Created on 2019/12/2
 *
 * @author connor.chen
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();
        System.out.println(futureTask.get());
        System.out.println(futureTask2.get());
    }
}
