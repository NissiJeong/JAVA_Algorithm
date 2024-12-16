package baekjoon.bronze;

/*
입력:
    1. 문자 메시지를 포함하는 한 행(영문자 알파벳 대문자 단어로만 구성, 띄어쓰기 구분)
출력:
    1. 산출된 행복지수(백분율), 소수점 이하 두 자리까지 반올림(PH, PG가 모두 0인 경우 행복 지수 0.5)
문제:
    1. 단어가 HAPPY 에 속하면 PH+=1, SAD 에 속하면 PG+=1
    2. PH / (PH+PG) * 100
로직:
    1. 문자열을 돌면서 HAPPY 에 속하는지 SAD 에 속하는지 카운트
    2. 각각의 카운트로 계산
*/

import java.io.*;

public class P30445_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String happy = "HAPPY";
        String sad = "SAD";

        String[] strArr = br.readLine().split("");

        double PH = 0;
        double PG = 0;
        for(int i=0; i<strArr.length; i++) {
            if(happy.contains(strArr[i])) {
                PH++;
            }
            if(sad.contains(strArr[i])) {
                PG++;
            }
        }

        if(PH == 0 && PG == 0) System.out.println("50.00");
        else {
            double avg = (double) Math.round((PH / (PH + PG)) * 10000.0) /100.0;
            String[] avgStr = String.valueOf(avg).split("\\.");
            System.out.println(avgStr[0]+"."+(avgStr[1]+"000").substring(0,2));
        }
    }
}