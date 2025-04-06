package src.arrays.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/
public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && k != j && nums[i] + nums[j] + nums[k] == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return triplets; //TODO
    }
}
