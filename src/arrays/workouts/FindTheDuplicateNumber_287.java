package src.arrays.workouts;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-the-duplicate-number
public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int val = -1;
        for (int num : nums) {
            if (numsSet.contains(num))
                return num;
            numsSet.add(num);
        }
        return val;
    }
}
