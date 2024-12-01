package baekjoon.silver;

import java.util.*;
import java.io.*;

public class P2529_S1 {
    static int k;
    static char[] arr;
    static long max = 0;
    static String maxStr = "";
    static long min = 9999999999L;
    static String minStr = "";
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[10];
        arr = new char[k];
        result = new int[k+1];
        for(int i=0; i<k; i++) arr[i] = st.nextToken().charAt(0);

        backTrack(0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static void backTrack(int depth) {
        for(int i=0; i<depth-1; i++) {
            if(arr[i] == '<') if(result[i] > result[i+1]) return;
            if(arr[i] == '>') if(result[i] < result[i+1]) return;
        }
        if(depth == k+1) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<k+1; i++) {
                sb.append(result[i]);
            }
            long temp = Long.parseLong(sb.toString());
            if(temp > max) {
                max = temp;
                maxStr = sb.toString();
            }
            if(temp < min) {
                min = temp;
                minStr = sb.toString();
            }
            return;
        }

        for(int i=0; i<=9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backTrack(depth+1);
                visited[i] = false;
            }
        }
    }
}