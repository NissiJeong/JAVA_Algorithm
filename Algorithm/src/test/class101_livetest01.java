package test;

import java.util.HashMap;
import java.util.Map;

public class class101_livetest01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int key = 5;

        findPairs(arr, key);
    }

    public static void findPairs(int[] arr, int key) {
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Pairs that sum up to " + key + ":");
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int needed = key - current;

            if (map.containsKey(needed)) {
                System.out.println("(" + needed + ", " + current + ")");
            }

            map.put(current, i);
        }
    }
}
