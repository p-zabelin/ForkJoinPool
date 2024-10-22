package com.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {

    private int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    protected Integer compute() {
        if (n <= 5) {
            return factorial(n);
        } else {
            FactorialTask left = new FactorialTask(n - 1);
            left.fork();
            int result = left.join();
            return n * result;
        }
    }
}
