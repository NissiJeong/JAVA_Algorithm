package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * dfs 이용하여 문제 풀이 연습!!
 */
public class P1686_S5 {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());

        char[][] arr = new char[row][col];
        visited = new boolean[row][col];

        for(int i=0; i<row; i++) {
            String grass = br.readLine();
            for(int j=0; j<col; j++) arr[i][j] = grass.charAt(j);
        }

        int count = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j] == '#' && !visited[i][j]) {
                    count++;
                    dfs(i,j,arr);
                }
            }
        }

        System.out.println(count);
    }



    public static void dfs(int i, int j, char[][] arr) {
        visited[i][j] = true;

        if(i+1 < arr.length && arr[i+1][j] == '#' && !visited[i+1][j]) {
            dfs(i+1, j, arr);
        }
        if(i-1>=0 && arr[i-1][j] == '#' && !visited[i][j]) {
            dfs(i-1, j, arr);
        }
        if(j-1>=0 && arr[i][j-1] == '#' && !visited[i][j-1]) {
            dfs(i, j-1, arr);
        }
        if(j+1 < arr[0].length && arr[i][j+1] == '#' && !visited[i][j+1]) {
            dfs(i, j+1, arr);
        }
    }
}
