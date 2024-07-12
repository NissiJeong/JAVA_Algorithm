package inflearn.chap02;

import java.util.*;

/*
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)
 */
public class SearchLargerInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] intArr = new int[n+1];
        intArr[0] = 0;
        for(int i=1; i<n+1; i++){
            intArr[i] = sc.nextInt();
        }

        System.out.println(findLargerInt(intArr));
    }

    public static String findLargerInt(int[] intArr){
        String answer = "";

        for(int i=1; i<intArr.length; i++){
            if(intArr[i] > intArr[i-1]) answer += intArr[i] + " ";
        }

        return answer;
    }
}
