package com.Pratice.interview_preparation_kit.sorting;

import java.io.*;
import java.util.*;


public class MarkAndToys {
    // Big O analysis = O(N log N) for sorting + O(N) for searching
    // Drop-Non dominant term O(N log N + N) => O(N log N)
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int countToy = 0;
        Arrays.sort(prices);

        for (int i = 0, sum = 0; i < prices.length; i++) {
            if ( (sum + prices[i]) <= k) {
                sum += prices[i];
                countToy++;
            }
        }
        return countToy;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/mark_and_toys/input/input03.txt"));

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
