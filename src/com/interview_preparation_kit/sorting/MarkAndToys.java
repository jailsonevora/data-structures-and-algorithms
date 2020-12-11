package com.interview_preparation_kit.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class MarkAndToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int countToy = 0;
        Arrays.sort(prices);

        for (int i = 0, sum = 0; i < prices.length; i++) {
            if ( (sum += prices[i]) <= k)
                countToy++;
        }
        return countToy;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/mark_and_toys/input/input17.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
