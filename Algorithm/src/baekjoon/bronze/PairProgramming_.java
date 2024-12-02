package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 대학교, 어느학교가 가장 술을 많이 먹는지?
 * 입력:
 *  1. 테스트케이스 T
 *  2. 학교명 +' '+ 술의 양
 * 출력:
 *  1. 제일 많이 술을 소비한 학교명
 * 로직:
 *  1. 우선수위 큐를 사용
 *  2. br 입력,
 *  3. 1..t 반복
 *  4. 클래스 새로 만들어서 학교명, 술의양 생성자
 */
public class PairProgramming_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<School> sPq = new PriorityQueue<>((p1, p2) -> p2.bottle - p1.bottle);

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int k=0; k<n; k++) {
                String[] strArr = br.readLine().split(" ");
                sPq.add(new School(strArr[0], Integer.parseInt(strArr[1])));
            }

            System.out.print(sPq.peek().schoolName);
        }
    }
}

class School {
    String schoolName;
    int bottle;

    public School(String schoolName, int bottle) {
        this.schoolName = schoolName;
        this.bottle = bottle;
    }
}