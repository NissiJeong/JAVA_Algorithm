package baekjoon.silver;

import java.io.*;

/**
 * 문제 분석
 * 1 2 3 4
 * 1 5 9 13
 * - 위 규칙대로 주어진 n 이 커질수록 별의 개수가 늘어난다.
 * - 규칙: 4n-3
 *
 * 문제 풀이
 * - 입력: int n
 * - n 만큼 반복하면서 4n-3 의 개수의 별 박스를 그린다.
 * - 재귀함수를 돌면서 String[][] 배열에 별을 담아놓는다.
 */
public class P10994_S4_R {

    static char[][] starArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        starArr = new char[4*n-3][4*n-3];

        createStarrArr(n, 0);

        for (char[] chars : starArr) {
            for (char c : chars) {
                //null 로 초기화 된 부분은 공백 처리
                if(c == 0) System.out.print(" ");
                else System.out.print(c);
            }
            System.out.println();
        }
    }

    static void createStarrArr(int n, int start){

        if(n == 0)
            return;

        for(int i=start; i<4*n-3+start; i++) {
            starArr[start][i] = '*';
            starArr[4*n-3-1+start][i] = '*';
        }

        for(int i=start; i<4*n-3+start; i++) {
            starArr[i][start] = '*';
            starArr[i][4*n-3-1+start] = '*';
        }

        createStarrArr(n-1, start+2);
    }
}
