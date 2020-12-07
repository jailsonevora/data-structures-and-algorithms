package com.interview_preparation_kit.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoDArrayDS {

    /*// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        final int _MAX = 6; // size of matrix
        final int _OFFSET = 2; // hourglass width
        int matrix[][] = new int[_MAX][_MAX];
        int maxHourglass = -63; // initialize to lowest possible sum (-9 x 7)

        // find maximum hourglass
        for(int i=0; i < _MAX - _OFFSET; i++){
            for(int j=0; j < _MAX - _OFFSET; j++){
                hourglass(i, j);
            }
        }

        int tmp = 0; // current hourglass sum

        // sum top 3 and bottom 3 elements
        for(int k = j; k <= j + _OFFSET; k++){
            tmp += matrix[i][k];
            tmp += matrix[i + _OFFSET][k];
        }

        // sum middle element
        tmp += matrix[i + 1][j + 1];

        if(maxHourglass < tmp){
            maxHourglass = tmp;
        }
    }*/

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int total = Integer.MIN_VALUE;
        for(int row = 0; row <= 3; row++){
            for(int col = 0; col <= 3; col++){
                // top hourglass
                int sumHourGlass = arr[row][col] + arr[row][col+1] + arr[row][col+2];
                // middle hourglass
                sumHourGlass += arr[row+1][col+1];
                // bottom hourglass
                sumHourGlass += arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];

                if(sumHourGlass > total)
                    total = sumHourGlass;
            }
        }
        return total;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/twod_array_ds/input/input03.txt"));

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
