package inflearn.chap02;

import java.util.*;

/*
소수(에라토스테네스 체)
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 */
public class FindPrimeNumber {

    public static int findPrimeNumber(int n){
        int asnwer = 0;
        int[] numberArr = new int[n+1];

        for(int i=2; i<=n; i++){
            if(numberArr[i] == 0){
                asnwer++;
                for(int j=i; j<=n; j=j+i)
                    numberArr[j] = 1;
            }
        }

        return asnwer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(findPrimeNumber(n));
    }
}
