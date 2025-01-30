package baekjoon.silver;

import java.util.*;

public class P1182_S2 {
    static int N,S;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();

        back(0,0,false);
        System.out.println(count);
    }

    static void back(int index, int sum, boolean isSelected) {
        if(index == N) {
            if(sum == S && isSelected) count++;
            return;
        }

        back(index+1, sum+arr[index], true);

        back(index+1, sum, isSelected);
    }
}