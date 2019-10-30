package com.atguigu.Interview.study.thread;

/**
 * Created on 2019/10/30
 *
 * @author connor.chen
 */
public class T1 {
    volatile int n = 0;
    public void add(){
        n++;
    }
}
