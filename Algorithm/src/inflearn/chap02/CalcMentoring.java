package inflearn.chap02;

import java.util.*;

/*
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

N: 학생수 / M: 테스트 수

4 3
3 4 1 2
4 3 2 1
3 1 4 2

3
 */
public class CalcMentoring {

    public static int calcMentoring(int n, int m, int[][] arr){

        Map<String, Integer> map = Map.of("1", 1, "2", 2);
        int answer = n*(n-1);

        

        for(int i=0; i<m; i++){
            for(int l=0; l<n; l++){
                for(int k=0; k<n; k++){
                    if(l!=k && arr[i][l] < arr[i][k]) {
                        answer--;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(calcMentoring(n, m, arr));
    }
}
