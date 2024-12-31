package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P1929_S3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++) {
            if(i==2) sb.append(i).append("\n");
            else if(i>2 && i%2 == 1) {
                boolean check = true;
                for(int j=2; j<=Math.sqrt(i); j++) {
                    if(i%j == 0) {
                        check = false;
                        break;
                    }
                }
                if(check) sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}