package com.interview_preparation_kit.search;

import java.io.*;
import java.util.*;

public class IceCreamParlor {

    public static void main(String[] arg) throws Exception {

        Scanner scanner = new Scanner(new File(
                "src/com/sample_test_cases/ice_cream_parlor/input/input14.txt"));//System.in

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }

    private static void whatFlavors(int[] cost, int money) {

        /*
        //brute-force O(N^2)
        for (int i = 0; i < cost.length; i++) {
            for (int j = i + 1; j < cost.length; j++) {
                if (cost[i] + cost[j] == money) {
                    //return;
                    System.out.println((i+1)+" "+(j+1));
                }
            }
        }*/

        /*
        //With sorting and binarySearch O(N log N) for sorting + O(log N) for searching
        // Drop Non-Dominant Terms O(N log N + log N) becomes O(N log N)
        Arrays.sort(cost);

        for (int i = 0; i < cost.length; i++) {
            int siblingIndex = Arrays.binarySearch(cost, money - cost[i]);
            //int siblingIndex = com.searching.BinarySearch.binarySearch(cost, money - cost[i]);
            //int siblingIndex = com.searching.BinarySearch.binarySearchRecursive(cost, money - cost[i], 0, cost.length-1);
            if (siblingIndex >= 0) { // Found it!
                // If this points at us, then the pair exists only if
                // there is another copy of the element. Look ahead of
                // us and behind us.
                if (siblingIndex != i ||
                        (i > 0 && cost[i-1] == cost[i]) ||
                        (i < cost.length - 1 && cost[i+1] == cost[i])) {
                    System.out.println(i+1);
                }
            }
        }*/

        //with hashtable
        // O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (map.containsKey(money - cost[i])) {
                System.out.println((map.get(money - cost[i]) + 1) + " " + (i+1) );
            }
            map.put(cost[i], i);
        }
    }
}
