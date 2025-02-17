package src.search.workouts;

//https://www.geeksforgeeks.org/search-almost-sorted-array/
public class SearchInAlmostSortedArray {
    public static int binarySearch(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (nums[mid] == target) return mid;
            else if (mid-1 >0 && nums[mid - 1] == target) return mid - 1;
            else if (mid + 1 < nums.length && nums[mid + 1] == target) return mid + 1;
            else if (target > nums[mid]) start = mid + 2;
            else end = mid - 2;
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 10, 40, 50, 80, 70}, target = 70;
        int result = binarySearch(arr, target);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}
