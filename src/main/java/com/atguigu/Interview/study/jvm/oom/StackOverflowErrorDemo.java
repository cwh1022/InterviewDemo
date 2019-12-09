package com.atguigu.Interview.study.jvm.oom;

/**
 * Created on 2019/12/9
 *
 * @author connor.chen
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        //Exception in thread "main" java.lang.StackOverflowError
        stackOverflowError();
    }
}
