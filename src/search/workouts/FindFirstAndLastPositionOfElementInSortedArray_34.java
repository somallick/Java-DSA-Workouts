package src.search.workouts;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public static int findFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid, occurrenceIndex = -1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (nums[mid] == target) {
                occurrenceIndex = mid; // store the index and proceed to left segment of array
                end = mid - 1;
            } else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return occurrenceIndex;
    }

    public static int findLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid, occurrenceIndex = -1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (nums[mid] == target) {
                occurrenceIndex = mid; // store the index and proceed to right segment of array
                start = mid + 1;
            } else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return occurrenceIndex;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstOccurrence(nums, target), findLastOccurrence(nums, target)};
    }

}
