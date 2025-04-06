package src.utility;

import java.util.List;
import java.util.Set;

public class PrintCollection {

    public static <T> void printList(List<T> list) {
        list.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public static <T> void printSet(Set<T> set) {
        set.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
