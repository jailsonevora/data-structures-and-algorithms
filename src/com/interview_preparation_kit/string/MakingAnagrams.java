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
            String keyA = new String(a.substring(i, i + 1).toCharArray());
            hsMp.put(keyA, hsMp.getOrDefault(keyA, 0)+1);
        }

        for (int i = 0; i < b.length(); i++) {
            String keyB = new String(b.substring(i, i + 1).toCharArray());
            if (hsMp.containsKey(keyB)){
                hsMp.put(keyB, hsMp.get(keyB)-1);
            }
            else
                hsMp.put(keyB, hsMp.getOrDefault(keyB, 0)+1);
        }

        int count = 0;
        for (Map.Entry str : hsMp.entrySet()){
            Integer integer = (int) str.getValue();
            if(integer < 0)
                count = count + Math.abs(integer);//(hsMp.get(key) - (hsMp.get(key)*2) );
            else if (integer >= 0)
                count += integer;
        }

        return ( (a.length()+1) + (b.length()+1) ) - count;
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
