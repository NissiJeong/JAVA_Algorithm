package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] levelArr = new int[5][5];
        int[][] timeArr = new int[5][5];
        int[] totalWork = new int[5];

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            levelArr[i][0] = Integer.parseInt(st.nextToken());
            levelArr[i][1] = Integer.parseInt(st.nextToken());
            levelArr[i][2] = Integer.parseInt(st.nextToken());
            levelArr[i][3] = Integer.parseInt(st.nextToken());
            levelArr[i][4] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            timeArr[i][0] = Integer.parseInt(st.nextToken());
            timeArr[i][1] = Integer.parseInt(st.nextToken());
            timeArr[i][2] = Integer.parseInt(st.nextToken());
            timeArr[i][3] = Integer.parseInt(st.nextToken());
            timeArr[i][4] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                totalWork[i] += levelArr[i][j] * timeArr[j][i];
            }
        }

        for (int ints : totalWork) {
            System.out.println(ints);
        }
    }
}
