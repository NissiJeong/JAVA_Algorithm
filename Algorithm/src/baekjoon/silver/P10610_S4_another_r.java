package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10610_S4_another_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(!str.contains("0")) {
            System.out.println("-1");
            return;
        }

        int[] arr = new int[10];
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            int k = Integer.parseInt(str.substring(i,i+1));
            arr[k] += 1;
            sum += k;
        }

        if(sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            while(arr[i] != 0) {
                sb.append(i);
                arr[i]--;
            }
        }

        System.out.println(sb);
    }
}
