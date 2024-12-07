package baekjoon.silver;

/*
같은 문제 인접행렬로 풀어보니 메모리 초과 발생
인접 리스트 bfs 로 풀어보자
정점, 간선 개념 알고
입력된 데이터 중 어떤 부분이 간선인지에 따라 인접리스트에서 값 넣는 조건 달라짐.
*/
import java.io.*;
import java.util.*;

public class P24444_S2 {
    static int N,M,R;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] orders;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList());
        }
        // visited, orders 초기화
        visited = new boolean[N+1];
        orders = new int[N+1];

        // 입력 받은 값으로 인접 리스트 값 바인딩
        // 간선의 개수 M 이니까 M번 입력받기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjList.get(n).add(m);
            adjList.get(m).add(n);
        }

        // 오름차순 방문을 위한 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(adjList.get(i));
        }

        // 입력받은 R 에서부터 bfs 진행
        bfs(R);

        // orders 출력
        for (int i = 1; i <= N; i++) {
            bw.write(orders[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(!visited[node]) {
                visited[node] = true;
                orders[node] = cnt++;

                for(int i=0; i<adjList.get(node).size(); i++) {
                    int next = adjList.get(node).get(i);
                    if(!visited[next]) {
                        queue.add(next);
                    }
                }
            }
        }
    }
}
