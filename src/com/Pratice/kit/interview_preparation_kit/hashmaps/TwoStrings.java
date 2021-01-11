package com.Pratice.kit.interview_preparation_kit.hashmaps;

import java.io.*;
import java.util.*;


public class TwoStrings {

    // O(S1 + S2)
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
            HashSet<Character> hsMap = new HashSet<>();
            for (char chS1: s1.toCharArray()) {
                hsMap.add(chS1);
            }

            for (char chS2: s2.toCharArray()){
                if(hsMap.contains(chS2))
                    return "YES";
            }
            return "NO";
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/two_strings/input/input07.txt"));

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
