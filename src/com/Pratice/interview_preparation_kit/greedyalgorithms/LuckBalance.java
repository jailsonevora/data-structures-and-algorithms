package com.Pratice.interview_preparation_kit.greedyalgorithms;

import java.io.*;
import java.util.*;

public class LuckBalance {

    // Big O-> O(N log N + N)
    // Drop - Non dominant term O(N) -> So we get O(N log N)
    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        int totalLuck = 0;
        ArrayList<Integer> importantContest = new ArrayList<>();

        for (int i = 0; i < contests.length; i++) {
            totalLuck += contests[i][0];
            if (contests[i][1] == 1)
                importantContest.add(contests[i][0]);
        }
        Collections.sort(importantContest);
        for (int i = 0; i < importantContest.size()-k; i++)
            totalLuck -= (2 * importantContest.get(i));

        return totalLuck;
    }

    static int luckBalanceWithImmutableArray(int k, int[][] contests) {

        int totalLuck = 0;
        int importantContest[] = new int[contests.length];

        for (int i = 0; i < contests.length; i++) {
            totalLuck += contests[i][0];
            if (contests[i][1] == 1)
                importantContest[i] = contests[i][0];
        }
        Arrays.sort(importantContest);
        for (int i = 0; i < importantContest.length-k; i++)
            totalLuck -= (2 * importantContest[i]);

        return totalLuck;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/luck_balance/input/input12.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
