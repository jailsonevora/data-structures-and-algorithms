package com.interview_preparation_kit.greedyalgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumAbsoluteDifferenceInAnArray {

    // Big O -> O(N log N)  for sorting + O(N)
    // Drop-Non dominant term O(N)
    // So the run-time is O(N log N)
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int minimumABS = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int result = (arr[i+1]) - (arr[i]);
            if (result < 0 )
                result = result - (result*2);

            if(minimumABS > result)
                minimumABS = result;
        }
        return minimumABS;
    }

    // O(N^2) not a efficient
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifferenceBruteForce(int[] arr) {

        int minimumABS = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                result = (arr[i]) - (arr[j]);
                if (result < 0 )
                    result = result - (result*2);

                if(minimumABS > result)
                    minimumABS = result;
            }
        }
        return minimumABS;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/minimum_absolute_difference_in_an_array/input/input10.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
