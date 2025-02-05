package baekjoon.silver;

import java.util.*;
import java.io.*;

public class P2529_S1 {
    static int k;
    static char[] arr;
    static String maxStr = "", minStr = "";
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[10];
        arr = new char[k];
        result = new int[k + 1];

        for (int i = 0; i < k; i++) arr[i] = st.nextToken().charAt(0);

        backTrack(0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static void backTrack(int depth) {
        if (depth == k + 1) { // 모든 숫자를 선택했을 때
            StringBuilder sb = new StringBuilder();
            for (int num : result) sb.append(num);

            if (maxStr.isEmpty() || sb.toString().compareTo(maxStr) > 0) {
                maxStr = sb.toString();
            }
            if (minStr.isEmpty() || sb.toString().compareTo(minStr) < 0) {
                minStr = sb.toString();
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (depth > 0) { // 부등호 조건 체크
                    if (arr[depth - 1] == '<' && result[depth - 1] >= i) continue;
                    if (arr[depth - 1] == '>' && result[depth - 1] <= i) continue;
                }

                visited[i] = true;
                result[depth] = i;
                backTrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
