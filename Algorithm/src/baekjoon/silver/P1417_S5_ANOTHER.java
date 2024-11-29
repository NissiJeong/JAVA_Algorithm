package baekjoon.silver;

import java.io.*;
import java.util.Arrays;

public class P1417_S5_ANOTHER {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int count = 0;

        if(n > 1) {
            int[] voteArr = new int[n-1];
            for(int i=0; i<n-1; i++) voteArr[i] = Integer.parseInt(br.readLine());

            while(true) {
                // 타 후보 투표수 오름차순 정렬
                Arrays.sort(voteArr);
                if(voteArr[n-2] < m) break;
                voteArr[n-2]--;
                m++;
                count++;
            }
        }

        System.out.print(count);
    }
}
