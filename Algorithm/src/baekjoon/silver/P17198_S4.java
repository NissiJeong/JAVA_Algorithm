package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 10X10 맵
출력:
    1. 소의 최소 개수
문제:
    1. 호수에서부터 탐색해서 헛간까지 가야되는 최소 개수
    2. 바위는 탐색할 수 없음
로직:
    1. 호수에서 bfs,dfs 탐색 하면서 경로별 카운트 해줘야 함
    2. 탐색이 다 종료된 후 최솟값 출력
    3. 바위는 탐색 안되고 기존 길도 탐색x
    4. 이동은 동서남북 4방향
*/

public class P17198_S4 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[N][N];
        int endX = 0, endY = 0;
        int startX = 0, startY = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                char c = str.charAt(j);
                if(c == 'B') {
                    endX = i;
                    endY = j;
                } else if(c == 'L') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = c;
            }
        }

        int min = dfs(map, startX, startY, endX, endY);
        System.out.println(min);
    }

    static int dfs(char[][] map, int sx, int sy, int ex, int ey) {
        Queue<Cows> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new Cows(sx, sy, 0));
        int minCnt = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Cows cCow = queue.poll();
            int cx = cCow.x;
            int cy = cCow.y;
            int cCnt = cCow.count;

            System.out.println("ex = " + ex + " | ey = " + ey);
            System.out.println("cx = " + cx + " | cy = " + cy);
            System.out.println();

            if(cx == ex && cy == ey) {
                System.out.println("cCnt = " + cCnt);
                minCnt = Math.min(minCnt, cCnt);
                continue;
            }

            if(!visited[cx][cy]) {
                visited[cx][cy] = true;

                for(int i=0; i<4; i++) {
                    int nx = cx+dx[i];
                    int ny = cy+dy[i];
                    if(nx>0 && nx<N && ny>=0 && ny<N && map[nx][ny]!='R' && !visited[nx][ny]) {
                        queue.add(new Cows(nx, ny, cCnt+1));
                    }
                }
            }
        }

        return minCnt-1;
    }
}

class Cows {
    int x,y,count;

    Cows(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
