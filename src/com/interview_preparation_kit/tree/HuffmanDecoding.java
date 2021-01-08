package com.interview_preparation_kit.tree;

import java.util.*;

abstract class Node1 implements Comparable<Node1> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node1 left, right;
    public Node1(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node1 tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node1 {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node1 {

    public HuffmanNode(Node1 l, Node1 r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}

class Decoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Node root) {
    }



}

public class HuffmanDecoding {


}
