package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2210_S2_dfs {
    static int N = 5;
    static String[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new String[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dfs(i, j);
            }
        }
    }

    static void dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        list.add(map[x][y]);

        stack.push(new int[]{x,y});
        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0], cy = cur[1];

            if(list.size() == 6) {
                set.add(String.join("",list));
                continue;
            }

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N) {
                    stack.push(new int[]{nx, ny});
                    list.add(map[nx][ny]);
                }
            }
        }
    }
}
