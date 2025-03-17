package src.recursion.workouts;

public class CheckSorted {
    public static boolean checkSorted(int[] ar, int index) {
        if (index == ar.length - 1)
            return true;
        if (ar[index] > ar[index + 1])
            return false;
        return checkSorted(ar, index + 1);
    }

    public static void main(String[] args) {
        int[] numArray = {2, 3, 4, 5, 6, 7, 8, 10};
        System.out.println("Sorted = " + checkSorted(numArray, 0));
    }
}

/*
i/p = [2, 3, 4, 5, 6, 7, 8, 10]
o/p = true

i/p = [2, 3, 4, 5, 0, 6, 7, 8, 10]
o/p = false

*/
