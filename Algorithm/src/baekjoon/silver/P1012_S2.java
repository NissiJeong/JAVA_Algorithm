package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 테스트 케이스의 개수 T
    2. 배추밭 가로길이 M, 세로길이 N, 배추 심어져 있는 위치 개수 K
    3. K줄에 배추의 위치 X, Y
출력:
    1. 최소 배추흰지렁이 마리 수
문제:
    1. 배추흰지렁이는 상하좌우 움직일 수 있다.
    2. 최소 배추흰지렁이 마리수는?!
로직:
    1. 배추밭을 전체 탐색해야 한다.
    2. 배추가 있는 땅에서만 탐색을 시작한다.
    3. 탐색한 곳은 다시 탐색하지 않는다.
    4. 지렁이는 상하좌우 4방향 탐색
    5. 탐색이 끝날때마다 지렁이 +1
*/

public class P1012_S2 {

    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            int[][] map = new int[M][N];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int worm = 0;
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j,map);
                        worm++;
                    }
                }
            }

            bw.write(worm+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int sx, int sy, int[][] map) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sx, sy});

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];

            if(!visited[cx][cy]) {
                visited[cx][cy] = true;

                for(int i=0; i<4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && !visited[nx][ny] && map[nx][ny]==1) {
                        stack.push(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
