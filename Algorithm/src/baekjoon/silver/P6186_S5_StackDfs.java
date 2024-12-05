package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6186_S5_StackDfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(stackDfs(N, M, arr));
    }

    public static int stackDfs(int n, int m, char[][] arr) {
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Stack<int[]> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '#' && !visited[i][j]) {
                    count++; // 새로운 영역 발견
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;

                    while (!stack.isEmpty()) {
                        int[] pop = stack.pop();
                        int x = pop[0], y = pop[1];

                        for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '#' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                stack.push(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return count; // 영역의 개수 반환
    }
}

