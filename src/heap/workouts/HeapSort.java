package src.heap.workouts;

/*
 * Heapsort uses the heap data structure for sorting.
 * The largest (or smallest) element is extracted from the heap (in O(1) time),
 * and the rest of the heap is re-arranged such that the next largest (or smallest) element
 * takes O(log n) time. Repeating this over n elements makes the overall
 * time complexity of a heap sort O(n log(n)).
 */
//https://www.geeksforgeeks.org/problems/heap-sort/1
public class HeapSort {
    public static void sort(int arr[]) {
        // code here
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyDown(arr, i, n);
        }
        int lastIndex = n - 1;
        while (lastIndex > 0) {
            swap(arr, lastIndex, 0);
            lastIndex--;
            maxHeapifyDown(arr, 0, lastIndex + 1);
        }
    }

    private static void maxHeapifyDown(int[] arr, int rootIndex, int size) {
        int largestIndex = rootIndex;
        int leftIndex = 2 * rootIndex + 1;
        int rightIndex = 2 * rootIndex + 2;

        while (leftIndex < size || rightIndex < size) {
            if (leftIndex < size && arr[largestIndex] < arr[leftIndex])
                largestIndex = leftIndex;
            if (rightIndex < size && arr[largestIndex] < arr[rightIndex])
                largestIndex = rightIndex;

            if (largestIndex == rootIndex) // root is in suitable position no further heapify required
                break;

            swap(arr, rootIndex, largestIndex);

            rootIndex = largestIndex;
            leftIndex = 2 * rootIndex + 1;
            rightIndex = 2 * rootIndex + 2;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 3, 1, 9, 11, 0, 4};
        sort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

