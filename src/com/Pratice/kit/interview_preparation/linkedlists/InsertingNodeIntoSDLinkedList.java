package com.Pratice.kit.interview_preparation.linkedlists;

import java.io.*;
import java.util.*;

public class InsertingNodeIntoSDLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    // Big O -> O(N) for inserting
    // O(1) for inserting at empty list
    // O(1) at head
    // O(N) at middle or end of the list
    // So O(1+1+N)-> Drop Constant we get O(N)
    static DoublyLinkedListNode sortedInsertReverseLookUp(DoublyLinkedListNode head, int data) {
        // Inserting with empty list
        if (head == null)
            return new DoublyLinkedListNode(data);
        // Inserting at head
        if (data < head.data) {
            DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
            temp.next = head;
            head.prev = temp;
            temp.prev = null;
            head = temp;
            return head;
        }

        DoublyLinkedListNode current = head;
        while(current != null){
            // Inserting at middle
            if(current.data > data){
                DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
                temp.next = current;
                current.prev.next = temp;
                current.prev = temp;
                temp.prev = current.prev;
                return head;
            }
            // Inserting at end of the list
            if(current.next == null) {
                DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
                current.next = temp;
                temp.next = null;
                temp.prev = current;
                return head;
            }
            current = current.next;
        }
        return head;
    }
    // Big O -> O(N) for inserting
    // O(1) for inserting at empty list
    // O(1) at head
    // O(N) at middle or end of the list
    // So O(1+1+N)-> Drop Constant we get O(N)
    static DoublyLinkedListNode sortedInsertRecursive(DoublyLinkedListNode head, int data) {
        // Inserting with empty list
        if (head == null)
            return new DoublyLinkedListNode(data);
        // Inserting at head
        else if (data <= head.data) {
            DoublyLinkedListNode temp = new DoublyLinkedListNode(data);
            temp.next = head;
            head.prev = temp;
            temp.prev = null;
            head = temp;
            return head;
        }
        else {
            // Inserting at middle or end of the list
            DoublyLinkedListNode rest = sortedInsertRecursive(head.next, data);
            head.next = rest;
            rest.prev = head;
            return head;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/com/sample_test_cases/Inserting_Node_Into_Sorted_Doubly_Linked_List/input/input07.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsertRecursive(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
