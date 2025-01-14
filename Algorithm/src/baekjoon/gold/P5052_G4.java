package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P5052_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1].startsWith(arr[i])) {
                    flag = false;
                    sb.append("NO\n");
                    break;
                }
            }

            if (flag) sb.append("YES\n");
        }

        System.out.println(sb);
    }
}
