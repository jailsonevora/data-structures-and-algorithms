package com.interview_preparation_kit.recursion;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FibonacciNumbers {

    /*Big O analysis -> O(2^N)
    * each node has 2 nodes
    * if we do this n times
    * we will have 2^N nodes*/
    public static int fibonacci(int n) {
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*Big O analysis - > O(N) with memoization*/
    public static int fibonacciWithMemoization(int n, int memo[]) {
        return fibonacci(n, new int[n + 1]);
    }

    /*Big O analysis - > O(N) with memoization*/
    public static int fibonacci(int n, int memo[]){
        if(n == 0 || n == 1)
            return n;
        if (memo[n] == 0)
            return fibonacciWithMemoization(n - 1, memo) + fibonacciWithMemoization(n - 2, memo);
        return n;
    }


    public static void main(String[] args)  throws IOException {
        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/fibonacci_numbers/input/input06.txt"));
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacciWithMemoization(n, new int[n]));
        //System.out.println(fibonacci(n));
    }
}
