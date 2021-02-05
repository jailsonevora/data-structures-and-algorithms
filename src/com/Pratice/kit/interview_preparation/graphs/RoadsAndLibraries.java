package com.Pratice.kit.interview_preparation.graphs;

import javax.swing.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RoadsAndLibraries {

    static class Graph {
        int v;
        LinkedList<Integer>[] adjList;
        public Graph(int v) {
            this.v = v;
            adjList = new LinkedList[v];
            for(int i = 0 ; i < v ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int u , int v) {
            adjList[u-1].add(v-1);
            adjList[v-1].add(u-1);
        }
        public void dfs(int i , boolean[] visited, ArrayList<Integer> tmp) {
            if(visited[i]) return;
            visited[i] = true;
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()) {
                int val = it.next();
                if(!visited[val]) {
                    dfs(val,visited,tmp);
                }
            }
            tmp.add(i);
            return;
        }
    }

    // Complete the roadsAndLibraries function below.
    // dfs, components, greedy
    // O(N)
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_lib <= c_road) return n * 1l * c_lib;
        Graph g = new Graph(n);
        for(int[] i : cities) {
            g.addEdge(i[0],i[1]);
        }
        long roads = 0;
        long components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                ArrayList<Integer> tmp = new ArrayList<>();
                g.dfs(i,visited,tmp);
                roads += (long)tmp.size() - 1l;
                components++;
            }
        }
        return (components * c_lib) + (c_road * roads);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/Pratice/sample_test_cases/interview_preparation/roads_and_libraries/input/input00.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
