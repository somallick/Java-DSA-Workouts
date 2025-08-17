package src.recursion.workouts;

//https://www.geeksforgeeks.org/dsa/program-check-array-sorted-not-iterative-recursive
public class CheckArraySorted {

    public boolean isSorted(int[] arr) {
        // code here
        return isSortedRE(arr, 0, arr.length);

    }

    //Using Recursion
    public boolean isSortedRE(int[] arr, int index, int size) {
        //If reached to last index then sorted
        //base case
        if (index + 1 == size)
            return true;
        //any value at an index is greater than the value of its next index then not sorted
        // one value
        if (arr[index] > arr[index + 1])
            return false;
        //process for all index till last
        //recursion take core of other value
        return isSortedRE(arr, index + 1, size);
    }

}
