package com.interview_preparation_kit.string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        Map<String,Integer> hsMp = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            String strFstIndex = new String(s.substring(i,i+1).toCharArray());
            String strSecIndex = new String(s.substring(i+1,i+2).toCharArray());
            if(strFstIndex.equals(strSecIndex))
                hsMp.put(strFstIndex+strSecIndex, hsMp.getOrDefault(strFstIndex+strSecIndex, 0)+1);
        }
        int total = 0;
        for( Map.Entry str : hsMp.entrySet() )
            total  += (int) str.getValue();

        return total;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/alternating_characters/input/input13.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
