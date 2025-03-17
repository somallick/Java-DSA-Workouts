package src.recursion.workouts;

public class SearchArray {

    public static <T> int linearSearch(T[] ar, int size, int index, T target) {
        if (index == size)
            return -1;
        else if (ar[index].equals(target))
            return index;
        else
            return linearSearch(ar, size, index + 1, target);
    }

    public static <T extends Comparable<T>> int binarySearch(T[] ar, int start, int end, T target) {
        int mid = start + ((end - start) / 2);
        if (start > end)
            return -1;
        else if (ar[mid].compareTo(target) == 0)
            return mid;
        else if (ar[mid].compareTo(target) > 0)
            return binarySearch(ar, start, mid - 1, target);
        else
            return binarySearch(ar, mid + 1, end, target);
    }

    public static int binarySearch(int[] ar, int start, int end, int target) {
        int mid = start + ((end - start) / 2);
        if (start > end)
            return -1;
        else if (ar[mid] == target)
            return mid;
        else if (ar[mid] > target)
            return binarySearch(ar, start, mid - 1, target);
        else
            return binarySearch(ar, mid + 1, end, target);
    }

    public static void main(String[] args) {
        Character[] ar = {'a', 'e', 'i', 'o', 'u'};
        Character target = 'e';
        System.out.println(linearSearch(ar, ar.length, 0, target) != -1 ? "Found" : "Not Found");
        System.out.println(binarySearch(ar, 0, ar.length - 1, target) != -1 ? "Found" : "Not Found");

        int[] numArray = {2, 3, 4, 5, 5, 6, 7, 8, 10};
        System.out.println(binarySearch(numArray, 0, numArray.length - 1, 2) != -1 ? "Found" : "Not Found");
    }
}
