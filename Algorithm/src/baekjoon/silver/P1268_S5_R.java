package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1268_S5_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][6];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int leader = 0;
        for(int i=1; i<=n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=1; j<=5; j++) {
                for(int k=1; k<=n; k++) {
                    if(i!=k && arr[i][j] == arr[k][j]) set.add(k);
                }
            }

            if(max < set.size()) {
                max = set.size();
                leader = i;
            }
            else if(max == set.size()) {
                leader = Math.min(leader, i);
            }
        }

        System.out.println(leader);
    }
}