package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력
    1. 컴퓨터의 수 N(N<=100, 정점)
    2. 직접 연결되어 있는 컴퓨터 쌍의 수 M(간선)
    3. 연결된 컴퓨터 쌍
출력
    1. 바이러스에 걸리게 되는 컴퓨터의 수
문제
    1. 1번 컴퓨터가 바이러스에 걸리면 연결된 모든 컴퓨터가 바이러스에 걸린다.
    2. 총 바이러스에 걸린 컴퓨터의 개수
로직
    1. 인접리스트에 정점 입력
    2. dfs, bfs 로 1번부터 탐색하면서 총 탐색의 개수 count
    3. 탐색한 데이터는 탐색X
*/

public class P2606_S3 {
    static int N, M;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        visited = new boolean[N+1];

        dfs();

        System.out.println(count-1);
    }

    static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]) {
                count++;
                visited[node] = true;

                for(int nextNode : adjList.get(node)) {
                    if(!visited[nextNode]) {
                        stack.push(nextNode);
                    }
                }
            }
        }
    }
}
