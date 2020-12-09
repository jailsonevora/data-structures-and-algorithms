package com.interview_preparation_kit.hashmaps;

import java.io.File;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // O(M+N)
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String,Integer> hashSMagazine = new HashMap<>();
        for (String mag : magazine) {
            hashSMagazine.put(mag,hashSMagazine.getOrDefault(mag,0)+1);
        }
        for(String nte: note){
            if(hashSMagazine.getOrDefault(nte,0)==0){
                System.out.println("No"); return;
            }
            else hashSMagazine.put(nte,hashSMagazine.get(nte)-1);
        }
        System.out.println("Yes");
    }

    // O(M*N)
    // Brute Force
    // Time limit exceeded for a large sample test
    // This is not efficient
    static void checkMagazineBF(String[] magazine, String[] note) {

        int count = 0;
        for (int j = 0; j < note.length; j++){
            for (int i = 0; i < magazine.length; i++){
                if(note[j].equals(magazine[i])) {
                    count++;
                    magazine[i] = null;
                    break;
                }
            }
        }
        if (count == note.length)
            System.out.println("Yes");
        else
            System.out.println("No");
    }


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/ransom_note/input/input03.txt"));

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazineBF(magazine, note);

        scanner.close();
    }
}
