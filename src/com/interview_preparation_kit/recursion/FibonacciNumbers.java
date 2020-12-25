package com.interview_preparation_kit.recursion;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FibonacciNumbers {

    public static int fibonacci(int n) {
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args)  throws IOException {
        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/fibonacci_numbers/input/input06.txt"));
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
