package com.interview_preparation_kit.recursion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DavisStaircase {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        return 0;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File(""));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
