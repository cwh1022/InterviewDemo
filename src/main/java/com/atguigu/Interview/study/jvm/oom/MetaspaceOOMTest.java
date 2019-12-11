package com.atguigu.Interview.study.jvm.oom;

import javassist.ClassPool;

/**
 * Created on 2019/12/9
 *
 * @author connor.chen
 * JVM参数
 * -XX:MetaspaceSize=5m -XX:MaxMetaspaceSize=5m
 *
 * java 8及以后的版本使用Metaspace来替代永久代。
 *
 * Metaspace是方法区在HotSpot中的实现，它与持久代最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存
 * 也即在java8中，class metadata(the virtual machines internal presentation of java class),被存储在叫做
 * Metaspace的Native memory
 *
 * 永久代（java8后被元空间Metaspace取代了）存放了以下信息：
 *  虚拟机加载的类信息
 *  常量池
 *  静态变量
 *  即时编译后的代码
 *
 *  模拟Metaspace空间溢出，我们不断生成往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小的
 */
public class MetaspaceOOMTest {

    static class OOMTest{ }


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            Class generate = generate("oOMTest" + i);
            System.out.println(generate.getSimpleName());
        }
    }


    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}
