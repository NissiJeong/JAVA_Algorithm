package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P6603_S2 {
    static int k;
    static int[] arr;
    static int[] result;
    static Map<Integer, Boolean> visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            arr = new int[k];
            result = new int[6];
            visited = new HashMap<>();

            for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());

            backTrack(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void backTrack(int start, int depth) {
        if(depth == 6) {
            for(int key : result) sb.append(key).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++) {
            int key = arr[i];
            if(!visited.getOrDefault(key, false)) {
                visited.put(key, true);
                result[depth] = key;
                backTrack(i+1, depth+1);
                visited.put(key, false);
            }
        }
    }
}