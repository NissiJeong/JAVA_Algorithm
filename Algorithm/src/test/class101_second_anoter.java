package test;

import java.util.HashMap;
import java.util.Map;

public class class101_second_anoter {

}

class Solution {
    public long solution(String[] arr1, String[] arr2) {
        long answer = 0;

        Map<Integer, Integer> arr1Map = new HashMap<>();
        Map<Integer, Integer> arr2Map = new HashMap<>();

        for(int i=0; i<arr1.length; i++) {
            int count = arr1Check(arr1[i]);
            if(count != Integer.MAX_VALUE)
                arr1Map.put(count, arr1Map.getOrDefault(count, 0)+1);
        }

        for(int i=0; i<arr2.length; i++) {
            int count = arr2Check(arr2[i]);
            if(count != Integer.MAX_VALUE)
                arr2Map.put(count, arr2Map.getOrDefault(count, 0)+1);
        }

        for(int key : arr1Map.keySet()) {
            if(arr2Map.containsKey(key)) {
                answer += (long) arr1Map.get(key) * (long) arr2Map.get(key);
            }
        }

        return answer;
    }

    int arr1Check(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') count++;
            else count--;

            if(count < 0) return Integer.MAX_VALUE;
        }
        return count;
    }

    int arr2Check(String str) {
        int count = 0;
        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == ')') count++;
            else count--;

            if(count < 0) return Integer.MAX_VALUE;
        }
        return count;
    }
}
