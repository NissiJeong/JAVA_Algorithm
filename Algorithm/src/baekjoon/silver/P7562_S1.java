package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 테스트 케이스의 개수
    2. 체스판 한 변의 길이 I (4<=I<=300)
    3. 나이트가 현재 있는 칸 cx, cy
    4. 나이트가 이동하려 하는 칸 nx, xy
출력:
    1. 최소 이동 개수
문제:
    1. 체스판 위의 나이트
    2. 나이트를 계속 움직여서 원하는 칸으로 몇번 이동?
    3. 한 번 이동 시 위(아래)두칸 오른쪽(왼쪽) 한칸, 오른쪽(왼쪽) 두칸 위(아래) 한칸 -> 8번의 경우의 수
    4. cx 를 탐색하면서 nx 가 되면 탈출
로직
    1. 입력 받은 I 로 arr[I][I] 초기화 -> 필요 없을 듯
    2. 깊이, 너비 탐색으로 나이트의 움직임을 탐색
    3. 나이트의 움직임을 계산해서 stack에 추가 -> 갔던곳은 의미 없으니까 안가도 됨
    4. 다음 나이트의 움직임이 nx, ny 라면 탈출
    5. 이동 경로마다 카운트 추가 -> node 로 관리해볼까?
문제
    1. 처음 stack dfs 로 구현했는데 정확히 구현한 것 같은데 터무니 없는 숫자가 나옴
    2. 나이트의 위치를 찍어보니 맞긴 맞는데 깊이우선 탐색하다 보니 한 방향으로 계속 움직이고 마지막 움직인 것에서 답이 나옴
    3. 나이트의 처음 움직임 다 탐색, 그 뒤 다음 탐색을 해야해서 무조건 bfs 로 해야됨!!
해결
    1. bfs 로 바꾸니 해결 완
*/

public class P7562_S1 {
    static int[] dx = {2,2,-2,-2,1,1,-1,-1};
    static int[] dy = {1,-1,1,-1,2,-2,2,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            int I = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            int count = dfs(I, cx, cy, nx, ny);
            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int I, int cx, int cy, int ex, int ey) {
        boolean[][] visited = new boolean[I][I];
        Queue<Node> stack = new LinkedList<>();
        stack.add(new Node(cx,cy, 0));

        while(!stack.isEmpty()) {
            Node cur = stack.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curCount = cur.count;

            if(curX == ex && curY == ey) {
                return curCount;
            }

            if(!visited[curX][curY]) {
                visited[curX][curY] = true;

                for(int i=0; i<8; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if(nx>=0 && nx<I && ny>=0 && ny<I && !visited[nx][ny]) {
                        stack.add(new Node(nx, ny, curCount+1));
                    }
                }
            }
        }

        return 0;
    }
}

class Node {
    int x,y;
    int count;

    Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}