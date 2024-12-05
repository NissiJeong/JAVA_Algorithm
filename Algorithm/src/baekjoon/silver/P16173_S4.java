package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 게임 구역의 크기 N
 *  2. 게임판 맵
 * 출력
 *  1. "HaruHaru" or "Hing"
 * 로직
 *  1. dfs 로 전체 탐색
 *  2. dfs 리턴을 -1 로 할 수 있을까?
 *  3.
 */
public class P16173_S4 {

    static boolean[][] visited;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        visited = new boolean[n][n];

        // 주어진 맵을 받는다.
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // dfs 를 사용하지만 모든 길을 갈 필요는 없다.
        // 범위를 벗어나는 숫자가 있다면 더 이상 들어가지 않는다. -> visited 체크 하는 부분을 빼보니 메모리 초과가 났다.
        //
        //
        dfs(0, 0, arr);

        System.out.println(check ? "HaruHaru" : "Hing");

    }

    static void dfs(int i, int j, int[][] arr) {
        // 왔던 길은 다시 가지 않도록.
        // 왔다가 끊겼으면 어떻게든 가지 않는다.
        if(visited[i][j]) return;

        //
        visited[i][j] = true;

        if(arr[i][j] == -1) {
            check = true;
            return;
        }

        if(j+arr[i][j] < arr[0].length) dfs(i, j+arr[i][j], arr);
        if(i+arr[i][j] < arr.length) dfs(i+arr[i][j], j, arr);
    }
}
