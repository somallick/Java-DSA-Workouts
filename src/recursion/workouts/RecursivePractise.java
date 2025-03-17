package src.recursion.workouts;

import src.utility.PrintCollection;

import java.util.ArrayList;
import java.util.List;

public class RecursivePractise {

    public static int sumToN(int n) {
        if (n < 1)
            return 0;
        int sum = n + sumToN(n - 1);
        return sum;
    }

    public static <T> void printArray(T[] ar, int size, int index) {
        if (index == size)
            return;
        System.out.println(ar[index]);
        printArray(ar, size, index + 1);
    }

    public static int maxIndexInArray(int[] ar, int size, int index, int maxiIndex) {
        if (index == size)
            return maxiIndex;
        if (ar[maxiIndex] < ar[index])
            maxiIndex = index;
        return maxIndexInArray(ar, size, index + 1, maxiIndex);
    }

    public static int maxInArray(int[] ar, int size, int index, int maxi) {
        if (index == size)
            return maxi;
        maxi = Math.max(maxi, ar[index]);
        return maxInArray(ar, size, index + 1, maxi);
    }

    public static void oddInArray(int[] ar, int size, int index) {
        if (index == size)
            return;
        if (ar[index] % 2 == 1)
            System.out.println(ar[index]);
        oddInArray(ar, size, index + 1);
    }

    public static void storeOddInList(int[] ar, int index, List<Integer> odds) {
        if (index == ar.length)
            return;
        if (ar[index] % 2 == 1)
            odds.add(ar[index]);
        storeOddInList(ar,index + 1, odds);
    }

    public static void main(String[] args) {
        int num = 10;
//        System.out.println("Sum = " + sumToN(num));
//        Integer[] ar = {2, 3, 4, 5, 5, 6, 7, 8};
//        printArray(ar, ar.length, 2);

        int[] numArray = {2, 3, 4, 5, 10, 5, 6, 7, 8};

//        System.out.println("Max = " + numArray[maxIndexInArray(numArray, numArray.length, 0, 0)]);
//        System.out.println("Max = " + maxInArray(numArray, numArray.length, 0, 0));
        oddInArray(numArray, numArray.length, 0);
        List<Integer> oddList = new ArrayList<>();
        storeOddInList(numArray, 0, oddList);
        PrintCollection.printList(oddList);
    }
}
