package com.Pratice.interview_preparation_kit.tree;

public class IsThisABinarySearchTree {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

    The Node class is defined as follows:
        class Node {
            int data;
            Node left;
            Node right;
         }
    */
    // O(n + n-1) with recursion
    // In-Oder traversals
    // For Graph the runtime is O(n + m)
    // where n is the number of nodes and
    // m is the number of edge
    // since Binary Tree is also a graph, the complexity is also
    // O(n + m)
    // the number of edges from a node in BST is 2, the maximum number of edges is n-1, so the complexity is O(n + n-1)
    // Drop Non-Dominant Term n-1 and the final runtime is O(n)
    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean checkBST(Node node, int min, int max) {
        if (node == null)
            return true;
        return min < node.data && node.data < max &&
                        checkBST(node.left, min, node.data) &&
                        checkBST(node.right, node.data, max);
    }
}
