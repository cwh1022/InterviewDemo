package com.atguigu.Interview.study.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/12/6
 *
 * @author connor.chen
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=================");
        o1 = null;
        System.gc();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
