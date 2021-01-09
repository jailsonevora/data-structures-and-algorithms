package com.StateOfTheArt.sorting;

public class QuickSort {

    void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);
        if(left < index - 1)
            quickSort(arr, left, index - 1);
        if(index < right)
            quickSort(arr, index, right);
    }

    int partition(int[] arr, int left, int right){
        int pivot = arr[(left + right) / 2]; //pick pivot
        while(left <= right){
            // Find element on left that should be on right
            while(arr[left] < pivot) left++;
            // Find element on right that should be on left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right); // swaps elements
                left++;
                right--;
            }
        }
        return left;
    }

    void swap(int[] arr, int left, int right){ return; }
}
