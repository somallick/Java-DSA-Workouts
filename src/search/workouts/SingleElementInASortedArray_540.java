package src.search.workouts;

// https://leetcode.com/problems/single-element-in-a-sorted-array
public class SingleElementInASortedArray_540 {

    // Sol 1 - XOR - O(n)
    public int singleNonDuplicateUsingXOR(int[] nums) {
        int value = 0;
        for(int num : nums)
            value = value ^ num;
        return value;
    }

    //Sol 2 - Using BS - O(log n)
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if(start == end) return nums[start]; // single element or point start and end at that element
            if(mid%2==1)
                mid--;
            // If repeating element is at even position,then single element must be on the right side
            if(nums[mid] == nums[mid+1])
                start = mid + 2;
            else
                end = mid; // Else single element must be on the left

        }
        return nums[start];
    }
}
