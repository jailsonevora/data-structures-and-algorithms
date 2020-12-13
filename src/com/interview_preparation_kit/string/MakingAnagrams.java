package com.interview_preparation_kit.string;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        Map<String,Integer> hsMp = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            hsMp.put(new String(a.substring(i, i++).toCharArray()), hsMp.getOrDefault(new String(a.substring(i, i++).toCharArray()), 0)+1);
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/sherlock_and_anagrams/input/input00.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
