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
        if(n == 1 || n==2)
            return n;
        if(n == 3)
            return 4;
        else
            return stepPerms(n - 1)+stepPerms(n - 2)+stepPerms(n - 3);
    }

    static int stepPermsWithMemoization(int n, HashSet<Integer> memo) {
        return stepPerms(n - 1)+stepPerms(n - 2)+stepPerms(n - 3);
    }

    static int stepPerms(int n, HashMap<Integer, Integer> memo) {
        if(n == 1 || n==2)
            return n;
        if(n == 3)
            return 4;
        if(!memo.containsKey(n))
            memo.put(n,stepPerms(n - 1, memo)+stepPerms(n - 2, memo)+stepPerms(n - 3, memo));
        return memo.get(n);
    }
    // Big O - > O(N)
    static int stepPermsWithItr(int n) {
        int[] memo = new int[n];

        if(n == 1 || n==2)
            return n;
        if(n == 3)
            return 4;
        memo[0] = 1; memo[1] = 2; memo[2] = 4;
        for (int i = 3; i < memo.length; i++)
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        return memo[memo.length - 1];
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
            // int res = stepPerms(n, new HashMap<>());


            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
