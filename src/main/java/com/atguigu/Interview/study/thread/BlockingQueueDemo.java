package com.atguigu.Interview.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/11/28
 *
 * @author connor.chen
 * @see java.util.concurrent.ArrayBlockingQueue:一个基于数组结构的有界阻塞队列，此队列按FIFO原则对元素进行排序
 * @see java.util.concurrent.LinkedBlockingQueue:一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通常高于ArrayBlockingQueue。
 * @see java.util.concurrent.SynchronousQueue:一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，
 *                          否则插入操作一直处于阻塞状态，吞吐量通常要高
 * 1. 队列
 *
 * 2. 阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *
 *  2.2 不得不阻塞，你如何管理
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
//        List list = new ArrayList();
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("a", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("a", 2L, TimeUnit.SECONDS);
//        blockingQueue.offer("a", 2L, TimeUnit.SECONDS);
    }
}
