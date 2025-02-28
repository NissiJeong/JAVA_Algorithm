package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int factorialNum = factorial(n);

        System.out.println(factorialNum);
    }

    private static int factorial(int n) {
        if(n <= 1) return 1;
        else return n * factorial(n-1);
    }
}
