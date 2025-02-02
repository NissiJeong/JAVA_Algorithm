package baekjoon.gold;

import java.util.*;

public class P9663_G4 {
    static int N;
    static boolean[] visited1;
    static boolean[] visited2;
    static boolean[] visited3;
    static int count = 0;

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

        for(int i=0; i<N; i++) {
            if(!visited1[i] && !visited2[row+i] && !visited3[row-i+(N-1)]) {
                visited1[i] = true;
                visited2[row+i] = true;
                visited3[row-i+(N-1)] = true;

                backTrack(row + 1);

                visited1[i] = false;
                visited2[row+i] = false;
                visited3[row-i+(N-1)] = false;
            }
        }
    }
}