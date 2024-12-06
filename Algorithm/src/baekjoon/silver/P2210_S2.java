package baekjoon.silver;

import java.io.*;
import java.util.*;

/*
입력:
    1. 다섯개의 줄 각각 5개의 정수
출력:
    1. 만들 수 있는 수들의 개수
로직:
    1. dfs 를 이용해서
    2. 전체 탐색 하는데 visited 관리를 안해도 된다..? -> set에 과정을 저장하며 없을 추가한게 없을 때만 통과
    3. 한 점의 4방향 5번 이동을 dfs 로 구현(범위 안 벗어나게)
    4. 만들어진 String 5 개 될때까지 탐색
    5. 만들어진 String set 에 담고
    6. set 개수 출력
 */
public class P2210_S2 {
    static int[][] arr;
    static Set<String> countSet = new HashSet<>(); //저장될 문자열 저장(중복 제거)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = 5;
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i,j);
            }
        }

        System.out.println(countSet.size());
    }

    // dfs 함수 구현
    public static void dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>(); //dfs 구현할 stack
        // 상하, 좌우 이동하기 위한 좌표
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        // 탐색하면서 만들 문자열 저장 변수
        String st = "";

        // 최초 시작점 스택에 추가
        stack.push(new int[]{i,j});
        // 시작 문자열 추가
        st += arr[i][j]+"";

        // 각 지점에서 스택 돌면서 비어있을 때까지 진행
        while(!stack.isEmpty()) {
            int[] pop = stack.pop(); //스택에서 하나씩 꺼내옴
            int x = pop[0], y = pop[1]; //스택에서 꺼낸 인덱스

            // 문자열이 6자리
            if (st.length() == 6) {
                countSet.add(st);
                continue;
            }

            // 각 지점에서 4번씩 돌면서 탐색
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위 안에 있을 때 스택에 넣고 탐색할 지점 추가
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    stack.push(new int[]{nx, ny});
                    st += arr[i][j] + "";//스택에서 꺼낸 인덱스의 값 문자열에 추가
                }
            }
        }

    }
}
