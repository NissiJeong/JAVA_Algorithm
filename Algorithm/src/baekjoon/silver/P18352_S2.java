package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력
    1. 도시의 개수 N(정점의 개수), 도로의 개수 M, 거리정보 K, 출발 도시의 번호 X
    (2<=N<=300000, 1<=M<=1000000, 1<=K<=300000, 1<=X<=N)
    2. M개의 줄에 컬쳐 도시 A,B (간선의 개수, 단방향)
출력
    1. 최단 거리가 K인 모든 도시 오름차순 출력
문제
    1. X 에서 출발해서 갈 수 있는 도시 중 최단거리가 K인 도시 찾기
로직
    1. 인접 리스트 adjList 에 도시 저장
    2. 간선 M개 저장(단방향이기 때문에 하나만 저장)
    3. 출발에서부터 bfs 를 하는데 거리가 K 넘어가면 더이상 탐색X
    4. 거리가 K이면 해당 도시 저장(PriorityQueue 에 저장하면 자동 정렬)
문제
    1. 첫번째 예제에서 3이 나오면 안되는데 3이 나옴.
*/

public class P18352_S2 {
    static int N, M, K, X;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
        }

        // 방문 기록 초기화
        visited = new boolean[N+1];

        // 너비우선탐색 시작
        bfs();

        // 출력
        if(pq.isEmpty()){
            bw.write("-1");
        }
        while(!pq.isEmpty()) {
            bw.write(pq.poll()+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<City> queue = new LinkedList<>();
        queue.add(new City(X, 0));

        while(!queue.isEmpty()) {
            City cur = queue.poll();
            int curCity = cur.city;
            int curCount = cur.count;

            if(!visited[curCity]) {
                visited[curCity] = true;
                if(curCount == K) {
                    pq.add(curCity);
                }

                for(int nextCity : adjList.get(curCity)) {
                    if(!visited[nextCity]) {
                        queue.add(new City(nextCity, curCount+1));
                    }
                }
            }
        }
    }
}

class City {
    int city;
    int count;

    City(int city, int count) {
        this.city = city;
        this.count = count;
    }
}
