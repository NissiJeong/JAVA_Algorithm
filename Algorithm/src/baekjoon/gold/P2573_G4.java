package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P2573_G4 {
    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int year = 0;
        while(true) {
            boolean check = false;
            int count = 0;
            visited = new boolean[N+1][M+1];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        check = true;
                        count++;
                        dfs(i,j);
                    }
                }
            }

            if(count >= 2) {
                System.out.println(year);
                return;
            }
            if(count == 0) {
                System.out.println(0);
                return;
            }

            int[][] meltCountArr = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int meltCount = 0;
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            meltCount++;
                        }
                    }
                    meltCountArr[i][j] = meltCount;
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = Math.max(0, map[i][j] - meltCountArr[i][j]);
                }
            }

            year++;

            if(!check) break;
        }

        System.out.println(0);
    }

    static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
}