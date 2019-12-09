package com.atguigu.Interview.study.jvm.oom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2019/12/9
 *
 * @author connor.chen
 * 高并发请求服务器超时，经常出现如下异常：java.lang.OutOfMemoryErro: unable to create new native thread
 * 准确的讲该Native thread异常与对应的平台有关
 *
 * 导致原因：
 *      1. 你的应用创建的线程太多了，一个应用进程创建多个线程，超过系统承载极限
 *      2. 你的服务器并不允许你的应用程序创建这么多线程，Linux系统默认允许单个线程可以创建的线程数是1024个
 *         你的应用创建超过这个数量，就会报java.lang.OutOfMemoryError： unable to create new native thread
 * 解决办法：
 *      1. 想办法降低你应用程序创建进程的数量，分析应用是否真的需要创建这么多线程，如果不是，改代码将线程数降到最低
 *      2. 对于有的应用，确实需要创建很多线程，远超Linux系统默认的1024个线程的限制，可以通过修改Linux服务器配置，扩大Linux默认限制
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0;  ; i++) {
            new Thread(() -> {
                System.out.println(atomicInteger.incrementAndGet());
                try { TimeUnit.MINUTES.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }
            }, String.valueOf(atomicInteger.incrementAndGet())).start();
        }
    }
}
