package baekjoon.silver;

import java.util.*;

public class P2607_S2_R {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        String str1 = sc.next();
        int count = 0;
        for(int i=0; i<N-1; i++) {
            String str2 = sc.next();
            if(check(str1, str2)) count++;
        }

        System.out.println(count);
    }

    static boolean check(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) return false;

        int[] arr = new int[26];

        for(char c : str1.toCharArray()) arr[c-'A']++;
        for(char c : str2.toCharArray()) arr[c-'A']--;

        int add = 0,remove = 0;
        for(int k : arr) {
            if(k>0) add += k;
            else remove -= k;
        }

        return add<2 && remove<2 && (add+remove)<3;
    }
}
