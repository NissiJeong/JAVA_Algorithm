package baekjoon.silver;

/*
입력:
    1. 20줄 수강한 전공과목 과목명+' '+학점+' '+등급
출력:
    1. 전공평점(오차10^-4이하)
문제:
    1. 전공평점 구하기
로직:
    1. 20번 돌면서
    2. 학점의 합 구하고
    3. 학점 * 등급의 합을 구하고
    4. P이면 계산에서 제외 F=0
*/

import java.io.*;
import java.util.*;

public class P25206_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Double> gradeMap = Map.of("A+",4.5, "A0",4.0,
                "B+",3.5, "B0",3.0,
                "C+",2.5, "C0",2.0,
                "D+",1.5, "D0",1.0, "F",0.0);

        double scoreSum = 0.0;
        double scoreByGradeSum = 0.0;
        for(int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String gStr = st.nextToken();
            double grade = gradeMap.getOrDefault(gStr, 0.0);
            double scoreByGrade = score*grade;

            if(!gStr.equals("P")){
                scoreSum += score;
                scoreByGradeSum += scoreByGrade;
            }
        }

        double result = scoreByGradeSum/scoreSum;

        System.out.println(result);
    }
}
