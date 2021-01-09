package com.Pratice.interview_preparation_kit.sorting;

import java.io.*;
import java.util.*;


public class BubbleSort {

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // O(N^2)
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int countSwap = 0;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    swap(a, i, i + 1);
                    countSwap++;
                    isSorted = false;
                }
            }
        }
        System.out.println("Array is sorted in "+ countSwap +" swaps.\n"+"First Element: "+a[0]+"\n"+"Last Element: "+a[a.length-1]);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/bubble_sort/input/input01.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
