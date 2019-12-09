package com.atguigu.Interview.study.jvm.oom;

/**
 * Created on 2019/12/9
 *
 * @author connor.chen
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        byte[] bytes = new byte[50 * 1024 * 1024];
    }
}
