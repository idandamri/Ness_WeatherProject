package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    static ThreadPoolExecutor executor;

    public static void main(String[] args) {

        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ThreadMenu T1 = new ThreadMenu("Thread-Menu");
        executor.execute(T1);
    }
}
