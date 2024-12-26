package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
입력:
    1. 반의 학생 수 n(3<=n<=1000)
    2. 1번 학생부터 차례대로 줄마다 1~5학년까지 몇반에 속했는지
출력:
    1. 임시반장 번호(중복될 경우 가장 작은 번호)
문제:
    1. 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로
로직:
    1. 최대 5000번이니까 이중 for 문 돌면서
    2. 각 번호를 키 값으로 몇번
    3. 입력받으면서 각 학년별 중복된 반들을 골라내서 그 반인 사람들의 번호를 카운트
*/


public class P1268_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[][] student_classes = new int[num][5];
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <5 ; j++){
                student_classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구현
        int max = 0;
        int leader = 0;
        for(int i = 0; i<num; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<5; j++){
                for(int k = 0; k<num; k++){
                    if(student_classes[i][j] == student_classes[k][j]
                            && i!=k){
                        set.add(k);
                    }
                }
            }
            if(set.size()>max) {
                leader = i;
                max = set.size();
            }
        }
        System.out.println(leader + 1);

    }
}
