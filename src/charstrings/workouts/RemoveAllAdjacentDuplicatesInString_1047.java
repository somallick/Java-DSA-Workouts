package src.charstrings.workouts;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
public class RemoveAllAdjacentDuplicatesInString_1047 {
    public static String removeDuplicates(String s) {
        String s1 = "";
        char[] charArr = s.toCharArray();
        for(char c : charArr){
            if(s1.isEmpty())
                s=String.valueOf(c);
            else {
                int l = s1.length();
                char lastChar = s1.charAt(l-1);
                if(lastChar == c)
                    s1=s1.substring(0,l-1);
                else
                    s1=s1+c;
            }
        }
        return s1;
    }
    public static String removeDuplicates_sol2(String s) {
        StringBuilder sb = new StringBuilder("");
        char[] charArr = s.toCharArray();
        for(char c : charArr) {
            int sbLength = sb.length();
            if(sbLength>0 && sb.charAt(sbLength-1)==c)
                sb.deleteCharAt(sbLength-1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
