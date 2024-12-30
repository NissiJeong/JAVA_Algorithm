package baekjoon.gold;

/*
입력:
    1. 방의 크기 N, M(3<=N,M<=50)
    2. 청소기가 있는 칸의 좌표(r,c) 방향 d(0,1,2,3 -> 북,동,남,서)
    3. N 행 M 열의 좌표(0인 경우 청소x, 1인 경우 벽)
출력:
    1. 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수
문제:
    1. dfs 로 풀면 되지 않나?
*/

import java.io.*;
import java.util.*;

public class P14503_G5 {
    static int N,M;
    static int r,c,d;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
            }
        }

        visited[r][c] = true;
        int count = simulate(r, c);

        System.out.println(count);
    }

    static int simulate(int x, int y) {
        int count = 1;

        while(true) {
            boolean check = false;
            for(int i=0; i<=3; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                Integer[] dir = direction(d);
                int nx = x+dir[0];
                int ny = y+dir[1];

                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] != 1 && !visited[nx][ny]) {
                    check = true;
                    count++;
                    x = nx;
                    y = ny;
                    visited[nx][ny] = true;
                    break;
                }
            }

            if(!check) {
                int nd = d-2>=0?d-2:d+2;
                Integer[] dir = direction(nd);
                int nx = x+dir[0];
                int ny = y+dir[1];

                if(map[nx][ny] == 1) {
                    break;
                }

                x = nx;
                y = ny;
            }
        }

        return count;
    }

    static Integer[] direction(int d) {
        Map<Integer, Integer[]> map = Map.of(0, new Integer[]{-1, 0}, 1, new Integer[]{0, 1}, 2, new Integer[]{1, 0}, 3, new Integer[]{0, -1});
        return map.get(d);
    }
}
