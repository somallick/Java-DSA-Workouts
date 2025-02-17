package src.search.workouts;

//https://leetcode.com/problems/search-in-rotated-sorted-array
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums); // O(log n)
        int start = 0, n = nums.length;
        int end = n - 1;
        if (target >= nums[start] && target <= nums[pivotIndex])
            return binarySearch(nums, start, pivotIndex, target); // first segment with pivot element //O(log n)
        else
            return binarySearch(nums, pivotIndex + 1, end, target); // second segment without pivot element //O(log n)
    }

    public static int findPivotIndex(int[] nums) {
        int start = 0, n = nums.length;
        int end = n - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (start == end)
                return start;
            else if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
