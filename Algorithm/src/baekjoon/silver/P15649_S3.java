package baekjoon.silver;

import java.util.*;

public class P15649_S3 {
    static int N,M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N+1];
        result = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if(depth == M) {
            for(int k : result) sb.append(k).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}