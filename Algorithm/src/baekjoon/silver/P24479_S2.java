package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 정점의 수 N (5<=N<=100000), 간선의 수 M(1<=M<=200000), 시작정점(1<=R<=N)
    2. M개 줄 간선정보 u,v (1<=u<v<=N), 모든 간선의 값은 다르다.
출력:
    1.
로직:
    1. dfs 를 구현해서 출력
    2. 방문할 수 없는 곳이면 0 출력
    3. 메모리 초과가 발생.. 어디가 문제?
문제 해결
    1. 메모리 초과라면 쓸데없이 메모리를 사용하는 곳을 찾아야 한다.
    2. 인접행렬은 구현이 쉽고 노드를 찾는데 O(1)의 시간이 걸리지만 메모리를 많이 사용
    3. 인접 리스트로 구현
    4. 인접 리스트는 메모리 측면에서 훨씬 이득
*/
public class P24479_S2 {
    static int N,M,R;
    static List<List<Integer>> map;
    static boolean[] visitedDfs;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            map.add(new ArrayList<>());
        }
        visitedDfs = new boolean[N+1];
        order = new int[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map.get(n).add(m);
            map.get(m).add(n);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(map.get(i));
        }

        //dfs_recursive(R);
        dfs(R);
        for (int i = 1; i <= N; i++) {
            bw.write(order[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs_recursive(int node) {
        visitedDfs[node] = true;
        order[node] = cnt++;

        for(int next : map.get(node)) {
            if(!visitedDfs[next]) {
                dfs_recursive(next);
            }
        }
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N+1];
        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]) {
                visited[node] = true;
                order[node] = cnt++;

                for(int i=map.get(node).size()-1; i>=0; i--){
                    int next = map.get(node).get(i);
                    if(!visited[next]) stack.push(next);
                }
            }
        }

    }
}
