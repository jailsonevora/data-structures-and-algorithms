package com.interview_preparation_kit.recursion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RecursiveDigitSum {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {

        StringBuilder p = new StringBuilder();
        for (int i = 0; i < k % 9; i++) {
            p.append(n);
        }
        return superDigit(p);
    }

    static int superDigit(StringBuilder p) {

        if( p.length() == 1 )
            return Integer.parseInt(p.toString());
        else {
            Integer superDigitSum = 0;
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
