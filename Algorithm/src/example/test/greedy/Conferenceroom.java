package example.test.greedy;

import java.io.IOException;
import java.util.Scanner;

public class Conferenceroom {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int confCount = sc.nextInt();
        int[] sTimes = new int[confCount];
        int[] eTimes = new int[confCount];
        boolean[] checks = new boolean[confCount];
        for(int i=0; i<confCount; i++){
            sTimes[i] = sc.nextInt();
            eTimes[i] = sc.nextInt();
        }
    }
}
