package com.Pratice.kit.interview_preparation.hashmaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Big O -> O(2arr)
    // Drop constant term -> O(N)
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> left = new HashMap<>();
        HashMap<Long, Long> right = new HashMap<>();

        long count = 0;
        // O(N)
        for(long listItem : arr)
            right.put(listItem, right.getOrDefault(listItem, 0L) + 1);

        // O(N)
        for (int i = 0; i < arr.size(); i++) {

            long mid = arr.get(i);
            long leftMidDivision = 0, rightMidMultiply = 0;

            right.put(mid, right.getOrDefault(mid, 0L) - 1);

            if(left.containsKey(mid / r) && mid % r == 0)
                leftMidDivision = left.get(mid / r);

            if(right.containsKey(mid * r))
                rightMidMultiply = right.get(mid * r);

            count += leftMidDivision * rightMidMultiply;

            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/Pratice/sample_test_cases/interview_preparation/count_triplets_1/input/input00.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
