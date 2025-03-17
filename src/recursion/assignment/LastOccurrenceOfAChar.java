package src.recursion.assignment;

//https://www.geeksforgeeks.org/problems/last-index-of-a-character-in-the-string4516/1
public class LastOccurrenceOfAChar {
    public static int lastOccurrence(String str, int index, char c) {
        // traverse from last index to first
        if (index < 0)
            return -1;
        if (str.charAt(index) == c)
            return index;
        return lastOccurrence(str, index - 1, c);
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        char c = 'k';
        System.out.println(lastOccurrence(str, str.length() - 1, c));
    }
}
