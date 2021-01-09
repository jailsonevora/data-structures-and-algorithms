package com.Pratice.interview_preparation_kit;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Vector
        //https://www.geeksforgeeks.org/java-util-vector-class-java/?ref=lbp
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.remove(1);
        vector.set(1,2);
        vector.get(1);
        vector.size();

        //Array
        int[] integer = new int[10];
        double[][] doubleMatrix = new double[4][4];
        String[] str = new String[10];
        float[] flt = new float[10];
        long[] lng = new long[10];
        Arrays.copyOf(integer,integer.length*2);
        // Copy elements of a[] to b[]
        //System.arraycopy(a, 0, b, 0, 3);

        //ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.set(1,2);
        arrayList.size();
        arrayList.get(1);
        arrayList.remove(1);

        //Stack
        //https://www.geeksforgeeks.org/stack-class-in-java/?ref=lbp
        Stack<Integer> stack = new Stack();
        stack.push(4);
        stack.pop();
        stack.peek();

        //Queue
        //https://www.geeksforgeeks.org/queue-interface-java/?ref=lbp
        Queue<Integer> queueLinkedList = new LinkedList<>();
        queueLinkedList.peek();
        queueLinkedList.add(1);
        queueLinkedList.remove();
        queueLinkedList.isEmpty();

        Queue<Integer> queuePriorityQueue = new PriorityQueue<>();
        queuePriorityQueue.peek();
        queuePriorityQueue.add(1);
        queuePriorityQueue.remove();
        queuePriorityQueue.isEmpty();

        Queue<Integer> queueArrayDeque = new ArrayDeque<>();
        queueArrayDeque.peek();
        queueArrayDeque.add(1);
        queueArrayDeque.remove();
        queueArrayDeque.isEmpty();

        //LinkedLists
        //https://www.geeksforgeeks.org/linked-list-in-java/?ref=lbp
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.remove(1);
        linkedList.set(1,2);
        linkedList.isEmpty();
        //Min-Heaps->PriorityQueue
        //https://www.geeksforgeeks.org/priority-queue-class-in-java-2/?ref=lbp
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.peek();
        minHeap.add(1);
        minHeap.poll();

        //Max-Heaps->PriorityQueue with Comparator.reserveOrder();
        //https://www.geeksforgeeks.org/priority-queue-class-in-java-2/?ref=lbp
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.peek();
        maxHeap.add(1);
        maxHeap.poll();

        //Hash Tables
        //https://www.geeksforgeeks.org/hashtable-in-java/
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1,"Test");
        hashtable.get(1);
        hashtable.remove(1);

        //Trees, Graphs and Tries
        //https://github.com/eugenp/tutorials/tree/master/data-structures

    }
}
