package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1051_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) map[i][j] = line.charAt(j)-'0';
        }

        int maxLen = 1;
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                for(int size = 1; (r+size<N) && (c+size<M); size++) {
                    if(map[r][c] == map[r][c+size] &&
                            map[r][c] == map[r+size][c] &&
                            map[r][c] == map[r+size][c+size]
                    ) {
                        maxLen = Math.max(maxLen, (size+1)*(size+1));
                    }
                }
            }
        }

        System.out.println(maxLen);
    }
}