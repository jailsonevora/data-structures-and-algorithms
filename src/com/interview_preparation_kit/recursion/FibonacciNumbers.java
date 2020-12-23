package com.interview_preparation_kit.recursion;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FibonacciNumbers {

    public static int fibonacci(int n) {
        return 0;
    }


    public static void main(String[] args)  throws IOException {
        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/fibonacci_numbers/input/input04.txt"));
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
