package com.interview_preparation_kit.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // O(2N) Drop Constant O(N)
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] temp = new int[a.length];
        for (int i = 0, j = d; j < a.length; i++,j++)
            temp[i] = a[j];
        for (int j = 0, i = (temp.length - d); i < temp.length; i++, j++){
            temp[i] = a[j];
        }
        return temp;
    }

    // O(N)
    static int[] rotLeftPrimitive(int[] a, int d) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++)
            temp[i] = a[(i + d) % a.length];
        return temp;
    }

    static int[] rotLeftArrayCpy(int[] a, int d) {
        int[] temp = new int[d];
        System.arraycopy(a, 0, temp, 0, d);
        System.arraycopy(a, d, a, 0, a.length - d);
        System.arraycopy(temp, 0, a, a.length - d, d);
        return a;
    }


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/array_left_rotation/input/input06.txt"));

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
