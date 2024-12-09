package baekjoon.gold;

import java.io.*;
import java.util.*;

/*
입력:
    1. 정점의 개수 N, 간선의 개수 M (1<=N,M<=100000)
    2. M 줄에 걸쳐 간선의 정보 u,v(1<=u,v<=N, u!=v)
    3. 팬곰이가 존재하는 정점의 개수 S
    4. S개의 팬곰이 정점 s
출력:
    1. 조건에 맞춰 Yes or yes
문제:
    1. 투곰이가 그래프 이동하면서 팬곰이를 만나면 Yes, 안만나면 yes
로직:
    1. 모든 길을 다 탐색하면서
    2. 한번이라도 팬곰이를 안만나면 Yes, 없으면 yes
    3. 탐색중에 팬곰이 만나명 더이상 탐색 안하고 contiue 하면 될 듯
로직 문제점
    1. 팬곰이 만날때마다 저장해놓고 set 의 크기와 비교해서 S 가 크면 만나지 않은 것이라 생각했는데
    2. 다른길에서 다른 팬곰이 만나더라도 딱 한 길에서 팬곰이 안만나면 yes 이다.
문제점 해결
    1. list 에 next node 없는 투곰이를 저장하고
    2. list 가 비어있지 않으면 yes 아니면 Yes
문제접
    1. 팬곰이가 1에 있다면 yes 가 나옴
*/

public class P25195_G4 {
    static int N, M, S;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static Map<Integer, Integer> fan = new HashMap<>();
    static List<Integer> meet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
        }

        visited = new boolean[N+1];

        // 팬곰이 개수 S
        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++) {
            int key = Integer.parseInt(st.nextToken());
            fan.put(key, fan.getOrDefault(key, 0)+1);
        }

        dfs(1);

        if(!meet.isEmpty()) System.out.println("yes");
        else System.out.println("Yes");
    }

    static void dfs(int start) {
        Stack<Bear> stack = new Stack();
        stack.push(new Bear(start, false));

        if(fan.getOrDefault(start, 0) == 1) {
            return;
        }

        while(!stack.isEmpty()) {
            Bear curB = stack.pop();
            int cV = curB.vertex;
            boolean cE = curB.isExist;

            if(cE) {
                continue;
            }

            if(!visited[cV]) {
                visited[cV] = true;

                // 다음 노드가 없고 팬곰이가 현재 없다면
                if(adjList.get(cV).isEmpty() && fan.getOrDefault(cV, 0) != 1) {
                    meet.add(cV);
                }

                for(int nV : adjList.get(cV)) {
                    if(!visited[nV]) {
                        // 팬곰이를 만나지 않았다면
                        if(fan.getOrDefault(nV, 0) != 1) stack.push(new Bear(nV, false));
                            // 팬곰이르 만났다면
                        else if(fan.getOrDefault(nV, 0) == 1) stack.push(new Bear(nV, true));
                    }
                }
            }
        }
    }
}

class Bear {
    int vertex;
    boolean isExist;

    Bear(int vertex, boolean isExist) {
        this.vertex = vertex;
        this.isExist = isExist;
    }
}