package src.dnc.workouts;

//https://leetcode.com/problems/merge-sorted-array
public class MergeSortedArray_88 {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, f = 0;
        int fnums[] = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                fnums[f++] = nums1[i];
                i++;
            } else {
                fnums[f++] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            fnums[f++] = nums1[i];
            i++;
        }

        while (j < n) {
            fnums[f++] = nums2[j];
            j++;
        }
        return fnums;
    }
}
