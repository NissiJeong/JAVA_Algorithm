package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * dfs 이용해서 풀어보자!!
 */
public class P1388_S4_dfs {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
        char[][] arr = new char[row][col];
        visited = new boolean[row][col];

        for(int i=0; i<row; i++) {
            String str = br.readLine();
            for(int j=0; j<col; j++) arr[i][j] = str.charAt(j);
        }

        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(!visited[i][j]) {
                    count++;
                    dfs(i, j, arr);
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int i, int j, char[][] arr) {
        visited[i][j] = true;

        if(i+1 < arr.length && arr[i][j] == '|' && arr[i+1][j] != '-') dfs(i+1, j, arr);
        if(j+1 < arr[0].length && arr[i][j] == '-' && arr[i][j+1] != '|') dfs(i, j+1, arr);
    }
}
