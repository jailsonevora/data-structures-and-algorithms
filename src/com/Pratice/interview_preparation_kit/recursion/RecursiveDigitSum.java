package com.Pratice.interview_preparation_kit.recursion;

import java.io.*;
import java.util.*;

public class RecursiveDigitSum {

    /*Big O -> O(N*K)
    Where O(K) to create the p String + O(N*K) for the super digit sum
    * Since we know that always N*K is large than K, we drop non-dominant term
    * and the run-time is O(N*K)*/
    static int superDigit(String n, int k) {
        // O(K)
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < k % 9; i++) {
            p.append(n);
        }
        // O(N*K)
        return superDigit(p);
    }
    /*Big O -> O(N*K)
    Where O(K) to create the p String + O(N*K) for the super digit sum
     * Since we know that always N*K is large than K, we drop non-dominant term
     * and the run-time is O(N*K)*/
    static int superDigit(StringBuilder p) {

        if( p.length() == 1 )
            return Integer.parseInt(p.toString());
        else {
            Integer superDigitSum = 0;
            // O(N*K)
            for (int i = 0; i < p.length(); i++) {
                superDigitSum += Integer.parseInt(p.substring(i,i+1));
            }
            return superDigit(new StringBuilder(superDigitSum.toString()));
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/recursive_digit_sum/input/input11.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
