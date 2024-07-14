package inflearn.chap02;

import java.util.*;

/*
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 */
public class FindLargerInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n+2][n+2];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(findLargerInt(n, arr));
    }

    private static int findLargerInt(int n, int[][] arr) {
        int answer = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(arr[i][j] > arr[i-1][j] &&
                    arr[i][j] > arr[i+1][j] &&
                    arr[i][j] > arr[i][j+1] &&
                    arr[i][j] > arr[i][j-1])
                    answer++;
            }
        }

        return answer;
    }
}
