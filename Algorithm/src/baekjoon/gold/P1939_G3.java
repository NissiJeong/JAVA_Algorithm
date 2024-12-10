package baekjoon.gold;

/*
입력:
    1. N(2<=N<=10000),M(1<=M<=100000)
    2. A,B,C(1<=A,B<=N), C(1<=C<=1000000000)
    3. 공장이 위치해 있는 섬의 번호 2개
출력:
    1. 조건에 맞는 답
문제:
    1. 다리마다 중량이 있고 중량을 넘기면 다리가 무너진다.
    2. 한번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값
로직
    1. 섬마다 bfs 탐색을 하고 최댓값을 갱신?
    2. bfs 내부에서는
로직 수정:
    1. 가장 무거운 무게를 찾아서
    2. 무게를 이분탐색으로 점점 올리거나 낮추거나
    3. 해당 무게가 탐색할 수 있는지 보면서 (dfs)
    4. 이분 탐색이 종료되면 return
*/

import java.io.*;
import java.util.*;

public class P1939_G3 {

    static int N,M;
    static int S,E;
    static List<City>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new City(b,c));
            adjList[b].add(new City(a,c));
            right = Math.max(right, c);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 이분탐색하면서 dfs 진행
        while(left <= right) {
            int mid = left + (right-left)/2;
            visited = new boolean[N+1];
            int flag = dfs(S, E, mid);
            if(flag != -1) left = mid+1;
            else right = mid-1;
        }

        System.out.println(right);
    }

    static int dfs(int start, int end, int limit) {
        Stack<City> stack = new Stack<>();
        stack.push(new City(start, 0));

        while(!stack.isEmpty()) {
            City cur = stack.pop();
            int cv = cur.vertex;
            int weight = cur.weight;

            if(cv == end) {
                return cv;
            }

            if(!visited[cv]) {
                visited[cv] = true;

                for(City nc : adjList[cv]) {
                    if(!visited[nc.vertex] && limit <= nc.weight) {
                        stack.push(new City(nc.vertex, weight));
                    }
                }
            }
        }

        return -1;
    }
}

class City {
    int vertex;
    int weight;

    City (int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
