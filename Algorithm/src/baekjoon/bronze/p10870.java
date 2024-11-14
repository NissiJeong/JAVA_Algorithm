package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fiboNum = fibonacci(n);

        System.out.println(fiboNum);
    }

    private static int fibonacci(int n) {
        if(n == 0) return n;
        else if(n==1) return 1 + fibonacci(n-1);
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}
