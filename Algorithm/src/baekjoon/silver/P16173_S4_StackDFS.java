package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
DFS!!!
 */
public class P16173_S4_StackDFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(N, arr) ? "HaruHaru" : "Hing");
    }

    public static boolean dfs(int n, int[][] arr) {
        boolean[][] visited = new boolean[n][n];
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0,0});
        visited[0][0] = true;

        while(!stack.isEmpty()) {
            int[] pop = stack.pop();
            int x = pop[0], y = pop[1];

            if(arr[x][y] == -1) {
                return true;
            }

            if(x+arr[x][y] >=0 && x+arr[x][y] < n && !visited[x+arr[x][y]][y]) {
                visited[x+arr[x][y]][y] = true;
                stack.push(new int[]{x+arr[x][y], y});
            }
            if(y+arr[x][y] >=0 &&  y+arr[x][y] < n && !visited[x][y+arr[x][y]]) {
                visited[x][y+arr[x][y]] = true;
                stack.push(new int[]{x, y+arr[x][y]});
            }
        }

        return false;
    }
}
