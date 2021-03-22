package example.test.greedy;

import java.io.IOException;
import java.util.Scanner;

public class CoinValue {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), k = sc.nextInt();
        int[] coins = new int[N];
        for(int i=0; i<N; i++){
            coins[i] = sc.nextInt();
        }

        int temp = 0;
        for(int i=coins.length-1; i>=0; i--){
            if(k>=coins[i]){
                temp += k/coins[i];
                k = k%coins[i];
            }
        }

        System.out.println(temp);
    }
}
