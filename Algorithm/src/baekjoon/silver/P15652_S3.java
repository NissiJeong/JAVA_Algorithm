package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P15652_S3 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        backtrack(1, 0);
        System.out.println(sb);
    }

    static void backtrack(int start, int depth) {
        if(depth == M) {
            for(int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            result[depth] = i;
            backtrack(i, depth+1);
        }
    }
}
