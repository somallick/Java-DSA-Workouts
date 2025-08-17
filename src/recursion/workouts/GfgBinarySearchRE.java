package src.recursion.workouts;

// https://www.geeksforgeeks.org/problems/binary-search-1587115620/1
// [Using Recursion with specific condition w.r.t problem statement]
public class GfgBinarySearchRE {
    public int binarySearch(int[] arr, int k) {
        return binarySearch(arr, 0, arr.length - 1, k, -1);
    }

    public int binarySearch(int[] arr, int start, int end, int target, int foundIndex) {
        if (start > end) {
            return foundIndex;
        }
        int mid = start + ((end - start) / 2);
        if (arr[mid] == target) {
            foundIndex = mid;
            return binarySearch(arr, start, mid - 1, target, foundIndex);
        } else if (target < arr[mid])
            return binarySearch(arr, start, mid - 1, target, foundIndex);
        else
            return binarySearch(arr, mid + 1, end, target, foundIndex);
    }

}
