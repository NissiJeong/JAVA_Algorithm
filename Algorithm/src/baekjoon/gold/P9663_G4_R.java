package baekjoon.gold;

import java.util.*;

public class P9663_G4_R {
    static int N;
    static int count = 0;
    static boolean[] visited1;
    static boolean[] visited2;
    static boolean[] visited3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited1 = new boolean[N];
        visited2 = new boolean[2*N];
        visited3 = new boolean[2*N];

        backTrack(0);

        System.out.println(count);
    }

    static void backTrack(int row) {
        if(row == N) {
            count++;
            return;
        }

        for(int col=0; col<N; col++) {
            if(!visited1[col] && !visited2[row+col] && !visited3[row-col+(N-1)]) {
                visited1[col] = true;
                visited2[row+col] = true;
                visited3[row-col+(N-1)] = true;

                backTrack(row+1);

                visited1[col] = false;
                visited2[row+col] = false;
                visited3[row-col+(N-1)] = false;
            }
        }
    }
}