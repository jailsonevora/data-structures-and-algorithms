package com.interview_preparation_kit.tree;

import java.util.*;
import java.io.*;

public class LowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        return null;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("src/com/ip_kit_sample_test_cases/binary_search_tree_lowest_common_ancestor/input/input00.txt"));
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

}
