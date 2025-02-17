package src.charstrings.workouts;

public class Basic {
    public static void main(String[] args) {
        char[] charArray = "Soumya@Mallick@".toCharArray();
        System.out.println(charArray);
        for(char c : charArray)
            System.out.print(c=='@'?' ':c);
        System.out.println();

        for(char c : charArray){
            c = (c>='A'&&c<='Z')?(char) (c - 'A' + 'a'):(c>='a'&&c<='z')?(char)(c - 'a' + 'A'): c;
            System.out.print(Character.valueOf(c));
        }
        System.out.println();
    }
}
