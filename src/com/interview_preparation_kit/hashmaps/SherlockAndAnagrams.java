package com.interview_preparation_kit.hashmaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    // O(N^2 + N) Drop Non-dominant term => O(N^2)
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        Map<String,Integer> hsString = new HashMap<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                char[] chars = s.substring(i, j).toCharArray();
                Arrays.sort(chars);
                hsString.put(new String(chars), hsString.getOrDefault(new String(chars), 0)+1);
            }
        }

        for (Map.Entry str : hsString.entrySet())
            count+= ((int)str.getValue()) * (((int)str.getValue()) - 1)/2;

        return count;
    }

    static int sherlockAndAnagramsCompact(String s) {

        Map<String,Integer> hsString = new HashMap<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                hsString.put(
                        Arrays.stream(s.substring(i,j).split("")).sorted().collect(Collectors.joining("")),
                        hsString.getOrDefault(new String(Arrays.stream(s.substring(i,j).split("")).sorted().collect(Collectors.joining(""))), 0)+1);
            }
        }

        for (Map.Entry str : hsString.entrySet())
            count+= ((int)str.getValue()) * (((int)str.getValue()) - 1)/2;

        return count;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/sherlock_and_anagrams/input/input01.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
