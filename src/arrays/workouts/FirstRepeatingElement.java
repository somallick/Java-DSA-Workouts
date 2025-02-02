package src.arrays.workouts;

import java.util.LinkedHashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/problems/first-repeating-element4018/1
public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr) {
        Map<Integer, Integer> numMap = new LinkedHashMap<>(); // LinkedHashMap so that number in the array should be serialised manner
        for (int num : arr){
            if(numMap.containsKey(num))
                numMap.put(num, numMap.get(num)+1);
            else
                numMap.put(num,1);
        }
        int index = 0;
        for(Integer countPerNum : numMap.values()){
            index++;
            if(countPerNum>1)
                return index;
        }
        return -1;
    }
}
