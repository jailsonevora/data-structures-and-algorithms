package com.Pratice.kit.problem_solving_kit.stacks;

import java.io.*;
import java.util.*;

public class MaximumElement {

    /*O(N)
    O(1) delete
    O(1) push
    O(1) peek*/
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(new File("src/com/ps_kit_sample_test_cases/stacks/maximum_element/input/input00.txt"));

        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        // O(N) for each query till greater than 0
        while (queries-- > 0) {
            switch(scanner.nextInt()){
                // O(1) for adding new element to stack
                case 1:{
                    int item = scanner.nextInt();
                    if(!stack.isEmpty())
                        item = item > stack.peek() ? item : stack.peek();
                    stack.push(item);
                    break;
                }
                // O(1) for deleting element from stack
                case 2:{
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                }
                // O(1) for printing element from stack
                case 3:{
                    if(!stack.isEmpty())
                        System.out.println(stack.peek());
                    break;
                }
            }
        }
        scanner.close();
    }
}
