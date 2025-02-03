package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1325_S1 {
    static int N, M;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] hackedCount;
    static int max = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) adjList.add(new ArrayList<>());

        hackedCount = new int[N + 1];
        Arrays.fill(hackedCount, -1); // 방문 여부를 -1로 초기화 (방문하지 않음)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v); // v -> u 방향 (u를 신뢰함)
        }

        for (int i = 1; i <= N; i++) {
            int count = dfs(i);
            max = Math.max(max, count);
        }

        for (int i = 1; i <= N; i++) {
            if (hackedCount[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int dfs(int start) {
        if (hackedCount[start] != -1) return hackedCount[start]; // 이미 방문한 경우 저장된 값 반환

        int count = 1; // 자기 자신 포함
        for (int next : adjList.get(start)) {
            count += dfs(next);
        }

        return hackedCount[start] = count; // 결과 저장 (메모이제이션)
    }
}
