package inflearn.chap02;

import java.util.*;

/*
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 */
public class FindLargestInt {

    public static int findLargestInt(int n, int[][] arr){
        int answer = 0;
        
        for(int i=0; i<n; i++){
            int rowSum = 0;
            int colSum = 0;
            int diaSum = 0;
            int reDiaSum = 0;
            
            for(int j=0; j<n; j++){
                rowSum += arr[i][j];
                colSum += arr[j][i];
                if(i==j) {
                    diaSum += arr[i][j];
                    reDiaSum += arr[arr.length-1-i][arr.length-1-j];
                }
            }

            if(answer < rowSum ) answer = rowSum;
            if(answer < colSum) answer = colSum;
            if(answer < diaSum) answer = diaSum;
            if(answer < reDiaSum) answer = reDiaSum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(findLargestInt(n, arr));
    }
}
