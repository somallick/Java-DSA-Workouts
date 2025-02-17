package src.search.workouts;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int start, int end, int target) {
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
