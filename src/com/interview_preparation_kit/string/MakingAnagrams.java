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

    // Big O -> O(A + B + (A ∩ B))
    // Drop Non-Dominant term => O(A+B)
    // If B > A it is O(B) otherwise if A > B it is O(A)
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        Map<String,Integer> hsMpA = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            String keyA = new String(a.substring(i, i + 1).toCharArray());
            hsMpA.put(keyA, hsMpA.getOrDefault(keyA, 0)+1);
        }

        for (int i = 0; i < b.length(); i++) {
            String keyB = new String(b.substring(i, i + 1).toCharArray());
            hsMpA.put(keyB, hsMpA.getOrDefault(keyB, 0)-1);
        }

        int count = 0;
        for (Map.Entry str : hsMpA.entrySet()){
            count  += Math.abs((int) str.getValue());
        }

        return count;
    }

    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/making_anagrams/input/input01.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
