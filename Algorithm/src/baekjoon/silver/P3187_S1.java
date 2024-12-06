package baekjoon.silver;

/*
입력:
    1. 가로 R, 세로 C (3<=R,C<=250)
    2. R 줄, C개 문자
출력:
    1. 살아남앙 양과 늑대의 수
문제:
    1. 양 k, 늑대 v
    2. k > v 양이 이김, else 늑대가 이김
    3. '.' 빈공간, '#' 울타리
    4. 울타리 안의 양과 늑대를 탐색하면 됨.
로직:
    1. dfs 로 울타리 아닌 부분 탐색
    2. 탐색하며 방문한 곳은 다시 방문 하지 않음
    3. 각 지점에서 탐색 하면서 양과 늑대 카운트
    3-1. 각 지점 k>v -> sheep += k, else wolf += v 처리
    4. 최종 sheep, wolf 출력
*/

import java.io.*;
import java.util.*;

public class P3187_S1{
    static int R,C;
    static boolean[][] visited;
    static char[][] map;
    static int sheepCount, wolfCount;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) map[i][j] = str.charAt(j);
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    countAnimals(i, j);
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
    }

    static void countAnimals(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        visited[x][y] = true;
        stack.push(new int[]{x, y});

        int sheep = 0, wolf = 0;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0], cy = cur[1];

            // 현재 위치에 양이나 늑대가 있으면 카운트
            if (map[cx][cy] == 'k') sheep++;
            if (map[cx][cy] == 'v') wolf++;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어나지 않고, 방문하지 않았으며, 울타리가 아닌 경우
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true; // 방문 처리
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        // 울타리 안의 양과 늑대 비교
        if (sheep > wolf) sheepCount += sheep;
        else wolfCount += wolf;
    }
}

