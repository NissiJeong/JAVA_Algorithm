package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1697_S1_R {
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = bfs(N);

        System.out.println(time);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[100001];
        Queue<Hide> queue = new LinkedList<>();
        queue.add(new Hide(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()) {
            Hide cur = queue.poll();
            int cX = cur.x;
            int cTime = cur.time;

            if(cX == K) {
                return cTime;
            }

            if(cX-1 >=0 && !visited[cX-1]) {
                queue.add(new Hide(cX-1, cTime+1));
                visited[cX-1] = true;
            }
            if(cX+1 <= 100000 && !visited[cX+1]) {
                queue.add(new Hide(cX+1, cTime+1));
                visited[cX+1] = true;
            }
            if(cX*2 <= 100000 && !visited[cX*2]) {
                queue.add(new Hide(cX*2, cTime+1));
                visited[cX*2] = true;
            }
        }

        return -1;
    }
}

class Hide {
    int x;
    int time;

    Hide(int x, int time) {
        this.x = x;
        this.time = time;
    }
}