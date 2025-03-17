package src.recursion.assignment;

//https://www.geeksforgeeks.org/problems/reverse-a-string/1
public class ReverseStringRE {
    public static String reverse(String str){
        if(str == null || str.length() <= 1)
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverse(str));
    }
}
