package baekjoon.silver;

import java.io.*;

/**
 * 문제 분석
 * - 예제에 숨겨진 규칙은?
 * - 1, 2, 3, 4
 * - 1, 5, 9, 13
 * - 한 변이 4씩 늘어나는 별 박스가 생김.
 * - 4n-3 의 규칙
 *
 * 문제 풀이
 * - int n을 입력 받음
 * - 전역 변수 이중 배열(starArr) 선언
 * - starArr의 사이즈는 4n-3
 * - 재귀 함수를 돌며 큰 박스부터 * 을 넣고 공백을 넣고
 *
 */
public class P10994_S4 {

    static String[][] starArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        br.close();

        starArr = new String[4*n-3][4*n-3];

        createStar(0, n);

        for (String[] strings : starArr) {
            for (String string : strings) {
                //null 로 초기화 된 부분은 공백 처리
                if(string == null) System.out.print(" ");
                //별 그리기
                else System.out.print(string);
            }
            System.out.println();
        }
    }

    static void createStar(int s, int n){

        // 재귀 탈출
        if(n == 0){
            return;
        }

        for(int i=s; i<4*n-3+s; i++){
            for(int j=s; j<4*n-3+s; j++){
                // 박스 가장 위 별 그리기
                if(i==s) starArr[i][j] = "*";
                // 박스 가장 아래 별 그리기
                else if(i==4*n-4+s) starArr[i][j] = "*";
                // 박스 왼쪽 별 그리기
                else if(j==s) starArr[i][j] = "*";
                // 박스 오른쪽 별 그리기
                else if(j==4*n-4+s) starArr[i][j] = "*";
            }
        }

        // 하나 작은 박스 그리기
        createStar(s+2,n-1);
    }
}
