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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P3187_S1_recursion {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int sheepCnt, wolfCnt;
    static int sheep, wolf;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) map[i] = br.readLine().toCharArray();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    sheep = 0;
                    wolf = 0;

                    recursiveDfs(i,j);

                    if(sheep > wolf) sheepCnt += sheep;
                    else wolfCnt += wolf;
                }
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }

    static void recursiveDfs(int x, int y) {
        //방문했던 곳이면 방문하지 않음
        if(visited[x][y]) {
            return;
        }

        //방문 체크
        visited[x][y] = true;

        //양, 늑대 체크
        if(map[x][y] == 'k') sheep++;
        if(map[x][y] == 'v') wolf++;

        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && map[nx][ny]!='#') {
                recursiveDfs(nx, ny);
            }
        }

    }
}

