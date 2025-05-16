package src.arrays.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/
public class ThreeSum_15 { // TC- O(n2)  SC- O(triplets size)
    //Best Sol
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        // Sort the array to apply two pointer approach
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // for similar i value duplicate triplets will occur
                continue;
            // two pointer j & k
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // to avoid similar triplets if j value are same consecutively
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                }
            }
        }
        return triplets;
    }
}
