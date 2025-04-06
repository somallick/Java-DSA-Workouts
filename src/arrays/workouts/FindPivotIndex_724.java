package src.arrays.workouts;

//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex_724 {
    public static int pivotIndex(int[] nums) {
        int totalSums = 0;
        for (int num : nums)
            totalSums += num;
        int leftSums = 0, rightSums = totalSums;
        for (int i = 0; i < nums.length; i++) {
            rightSums = rightSums - nums[i];
            if (leftSums == rightSums)
                return i;
            leftSums = leftSums + nums[i];
        }
        return -1;
    }
}
