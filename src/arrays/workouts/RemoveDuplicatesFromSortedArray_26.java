package src.arrays.workouts;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int pointer = 1, index = 1, n = nums.length;
        while (index < n) {
            if (nums[index - 1] != nums[index]) {
                nums[pointer] = nums[index];
                pointer++;
            }
            index++;
        }
        return pointer;
    }
}
