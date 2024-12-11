package baekjoon.gold;

import java.io.*;
import java.util.*;

/*
입력:
    1. 노드의 개수 N, 거리를 알고 싶은 노드 쌍의 개수 M (2<=N<=1000, 1<=M<=1000)
    2. N-1 줄 동안 트리 상에 연결된 두 점과 거리 (<=10000)
    3. M 줄 동안 거리를 알고 싶은 노드 쌍
출력:
    1. M 개 노드 쌍의 거리
문제:
    1. N 개의 노드로 이루어진 트리, M개의 두 노드 쌍들의 거리
로직:
    1. 이건 걍 dfs 로 거리 구하기 아님?
*/

public class P1240_G5 {

    static List<List<NodeInfo>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adjList.get(x).add(new NodeInfo(y, l));
            adjList.get(y).add(new NodeInfo(x, l));
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];

            int length = dfs(s,e);
            bw.write(length+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int start, int end) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(start, 0));

        while(!stack.isEmpty()) {
            NodeInfo cur = stack.pop();
            int cv = cur.vertex;
            int cl = cur.len;

            if(cv == end) {
                return cl;
            }

            if(!visited[cv]) {
                visited[cv] = true;

                for(NodeInfo next : adjList.get(cv)) {
                    if(!visited[next.vertex]) {
                        stack.push(new NodeInfo(next.vertex, cl+next.len));
                    }
                }
            }
        }

        return -1;
    }
}

class NodeInfo {
    int vertex;
    int len;

    NodeInfo(int vertex, int len) {
        this.vertex = vertex;
        this.len = len;
    }
}
