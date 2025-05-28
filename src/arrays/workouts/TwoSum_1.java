package src.arrays.workouts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum_1 {

    //Best Sol - TC O(n) SC O(n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            // current + x = target => x = target - current
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // Average sol TC O(n log n) SC O(1)
    public int[] twoSum_Sol3(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // O(n logn)
        int start = 0, end = n - 1;
        int[] result = {-1, -1};

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else
                result = new int[]{start, end};
        }
        return result;
    }

    // Bad sol TC O(n2) SC O(1)
    public int[] twoSum_Sol2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}
