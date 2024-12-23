package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P10610_S4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if(!str.contains("0")) {
            System.out.println("-1");
            return;
        }

        Integer[] arr = new Integer[str.length()];
        long sum = 0;
        for(int i=0; i<str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i,i+1));
            sum += arr[i];

        }

        if(sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
