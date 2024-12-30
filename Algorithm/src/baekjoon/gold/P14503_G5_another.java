package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14503_G5_another {
    static int N,M;
    static int r,c,d;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[ ]dy = {0, 1, 0, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d);

        System.out.println(count);
    }

    private static void clean(int x, int y, int dir) {
        map[x][y] = -1;

        for(int i=0; i<4; i++) {
            dir = (dir+3)%4;

            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
                count++;
                clean(nx, ny, dir);
                return;
            }
        }

        int d = (dir+2)%4;
        int bx = x+dx[d];
        int by = y+dy[d];
        if(bx>=0 && bx<N && by>=0 && by<M && map[bx][by] != 1) {
            clean(bx, by, dir);
        }
    }
}
