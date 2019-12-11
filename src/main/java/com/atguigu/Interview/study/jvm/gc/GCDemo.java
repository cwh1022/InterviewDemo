package com.atguigu.Interview.study.jvm.gc;

import java.util.Random;

/**
 * Created on 2019/12/10
 *
 * @author connor.chen
 *
 * 1. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC      (DefNew+Tenured)
 *
 * 2. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC      (ParNew+Tenured)
 *
 *  备注情况：Java HotSpot(TM) 64-Bit Server VM warning:
 *  Using the ParNew young collector with the Serial old collector is deprecated
 *  and will likely be removed in a future release
 *
 * 3. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC      (PSYoungGen+ParOldGen)
 * 4
 *  4.1 -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParaleelOldGC  (PSYoungGen+ParOldGen)
 *  4.2 不加就是默认UseParallelGC
 *      -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                        (PSYoungGen+ParOldGen)
 *
 * 5. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC      (par new generation+concurrent mark-sweep generation)
 *
 * 6. -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC               后面单独说
 *
 * 7. （理论直到即可，实际中已经被优化掉了，没有了）
 *   -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC      (PSYoungGen+ParOldGen)
 *
 * 下面是故意繁琐配置，主要是为了学习，一般生产不会这么配置：
 * 下面是故意繁琐配置，主要是为了学习，一般生产不会这么配置：
 * 下面是故意繁琐配置，主要是为了学习，一般生产不会这么配置：
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC  (PSYountGen + ParOldGen)
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC  (par new generation + concurrent mark-sweep generation)
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("---------GC Hello");
        try {
         String str = "study";
         while (true){
             str += str + new Random().nextInt(77777)+new Random().nextInt(88888888);
             str.intern();
         }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
