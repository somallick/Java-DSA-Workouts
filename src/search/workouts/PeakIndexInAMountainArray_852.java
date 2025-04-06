package src.search.workouts;

//https://leetcode.com/problems/peak-index-in-a-mountain-array
public class PeakIndexInAMountainArray_852 {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + ((end - start) / 2);
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (arr[mid] < arr[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return mid;
    }
}
