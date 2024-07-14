package inflearn.chap02;

import java.util.*;

/*
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.
 */
public class FindPrimeNumber2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=sc.nextInt();
		}

        for(int x : arr)
            System.out.print(findPrimeNumber(x));
    }

    private static String findPrimeNumber(int n) {
        int asnwer = 0;
        char[] nStr = (n+"").toCharArray();
        int lt = 0, rt = nStr.length-1;
        while(lt < rt){
            char temp = nStr[lt];
            nStr[lt] = nStr[rt];
            nStr[rt] = temp;
            lt++;
            rt--;
        }
        int rN = Integer.parseInt(String.valueOf(nStr));

        if(!isPrime(rN)) return "";

        return rN+" ";
    }

    public static boolean isPrime(int num){
		if(num==1) return false;
		for(int i=2; i<num; i++){
			if(num%i==0) return false;
		}
		return true;
	}
}
