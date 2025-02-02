package src.arrays.workouts;

//https://leetcode.com/problems/maximum-average-subarray-i
public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sums = 0, max = 0;
        for (int i = 0; i < k; i++)
            sums += nums[i];
        max = sums;
        for (int i = k; i < n; i++) {
            sums = sums + nums[i] - nums[i - k]; // sliding the K size window one by one index
            if (max < sums)
                max = sums;
        }
        return max / k;
    }
}
