package src.recursion.workouts;

import src.utility.PrintCollection;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-subsequences-string
//https://www.geeksforgeeks.org/problems/power-set4302/1
public class IncludeExcludePattern {
    //TC - O(n2^n) SC - O(n)
    public static void allSubsequence(String str, int index, String output) {
        // base case
        if (index == str.length()) {
            System.out.print(output + " ");
            return;
        }
        char ch = str.charAt(index);
        // include case
        allSubsequence(str, index + 1, output + ch);

        //exclude case
        allSubsequence(str, index + 1, output);
    }

    public static void allSubsequence(String str, int index, StringBuilder output) {
        // base case
        if (index == str.length()) {
            System.out.print(output + " ");
            return;
        }
        char ch = str.charAt(index);
        // include case
        allSubsequence(str, index + 1, new StringBuilder(output).append(ch)); // String builder is mutable

        //exclude case
        allSubsequence(str, index + 1, new StringBuilder(output));
    }

    public static void allSubsequence(String str, int index, String output, List<String> list) {
        // base case
        if (index == str.length()) {
            list.add(output);
            return;
        }
        char ch = str.charAt(index);
        // include case
        allSubsequence(str, index + 1, output + ch, list);

        //exclude case
        allSubsequence(str, index + 1, output, list);
    }

    public static void main(String[] args) {
        String str = "abc";
        allSubsequence(str, 0, "");
        System.out.println();
        allSubsequence(str, 0, new StringBuilder());
        System.out.println();
        List<String> list = new ArrayList<>();
        allSubsequence(str, 0, "", list);
        PrintCollection.printList(list);
    }
}
