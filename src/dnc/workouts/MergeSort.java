package src.dnc.workouts;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/merge-sort/1
public class MergeSort {
    // S.C - O(n), T.C - O(n log n)
    static void mergeSort(int arr[], int l, int r) {
        // code here
        //Base Case
        if (l >= r)
            return;
        //Divide
        int mid = l + (r - l) / 2;
        //left part
        mergeSort(arr, l, mid);
        //right part
        mergeSort(arr, mid + 1, r);
        //Conquer
        merge(arr, l, mid, r);
    }

    static void merge(int arr[], int left, int mid, int right) {

        // Store the two part in separate array/list
        List<Integer> tempLeft = new ArrayList<>();
        List<Integer> tempRight = new ArrayList<>();
        for (int i = left; i <= mid; i++) {
            tempLeft.add(arr[i]);
        }
        for (int j = mid + 1; j <= right; j++) {
            tempRight.add(arr[j]);
        }

        // perform merge ops of two sorted array/list
        int i = 0, j = 0, f = left;
        int m = tempLeft.size(), n = tempRight.size();
        while (i < m && j < n) {
            if (tempLeft.get(i) <= tempRight.get(j)) {
                arr[f++] = tempLeft.get(i);
                i++;
            } else {
                arr[f++] = tempRight.get(j);
                j++;
            }
        }

        // store the rest elements if any
        while (i < m) {
            arr[f++] = tempLeft.get(i);
            i++;
        }
        // store the rest elements if any
        while (j < n) {
            arr[f++] = tempRight.get(j);
            j++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,1,3,9,7};
        mergeSort(arr, 0, arr.length-1);
        for(int ar : arr) {
            System.out.print(ar + " ");
        }
        System.out.println();
    }
}
