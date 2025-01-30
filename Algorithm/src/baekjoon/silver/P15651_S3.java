package baekjoon.silver;

import java.util.*;

public class P15651_S3 {
    static int N,M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if(depth == M) {
            for(int k:result) sb.append(k).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            result[depth] = i;
            backTracking(depth+1);
        }
    }
}