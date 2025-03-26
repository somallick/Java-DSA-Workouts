package src.charstrings.workouts;

//https://leetcode.com/problems/remove-all-occurrences-of-a-substring
public class RemoveAllOccurrencesOfASubstring_1910 {
    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "aabababa";
        System.out.println(removeOccurrences(s, "aba"));
    }
}
