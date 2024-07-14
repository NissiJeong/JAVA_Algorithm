package inflearn.chap02;

import java.util.*;

/*
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

5
87 89 92 100 76
4  3  2  1  5
 */
public class CalcRank {

    public static String caclRank(int[] arr){
        String answer = "";

        for(int i=0; i<arr.length; i++){
            int rank = 1;
            for(int j=0; j<arr.length; j++)
                if(i!=j && arr[i] < arr[j]) rank++;
            answer += rank + " ";
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(caclRank(arr));
    }
}
