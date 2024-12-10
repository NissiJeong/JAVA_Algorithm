package baekjoon.silver;

/*
입력
    1. 수빈이가 있는 위치 N, 동생이 있는 위치 K
출력
    1. 동생을 찾는 가장 빠른 시간
문제
    1. 수빈이가 N에서 K까지 가는 가장 빠른 시간을 구하자
    2. 걸으면 x-1, x+1 순간이동하면 2*x 로 이동
로직
    1. 너비우선 탐색으로 탐색
    2. 한번에 1,-1,*2 세개의 탐색을 동시에 해서
    3. N이 K가 되는 순간 탐색 종료
    4. 시간까지 계산해야 하니 Node 로 관리
*/

import java.io.*;
import java.util.*;

public class P1697_S1 {
    static int N,K;
    static Map<Integer, Boolean> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new HashMap<>();

        int time = bfs();

        System.out.println(time);
    }

    static int bfs () {
        Queue<Find> fQueue = new LinkedList<>();
        fQueue.add(new Find(N, 0));

        while(!fQueue.isEmpty()) {
            Find cf = fQueue.poll();
            int cx = cf.x;
            int cTime = cf.time;

            if(cx == K) {
                return cTime;
            }

            if(!visited.getOrDefault(cx, false)) {
                visited.put(cx, true);

                if((cx-1)>=0 && (cx-1)<=100000 && !visited.getOrDefault((cx-1), false)) {
                    fQueue.add(new Find((cx-1), cTime+1));
                }
                if((cx+1)>=0 && (cx+1)<=100000 && !visited.getOrDefault((cx+1), false)) {
                    fQueue.add(new Find((cx+1), cTime+1));
                }
                if((2*cx)>=0 && (2*cx)<=100000 && !visited.getOrDefault((2*cx), false)) {
                    fQueue.add(new Find((2*cx), cTime+1));
                }
            }
        }

        return -1;
    }
}

class Find {
    int x;
    int time;

    Find(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
