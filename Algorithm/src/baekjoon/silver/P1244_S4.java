package baekjoon.silver;

/*
입력:
    1. 스위치의 개수(0<n<=100)
    2. 각 스위치의 상태
    3. 학생수(0<s<=100)
    4. 학생수 만큼 성별 + 받은 수(남1, 여2, 0<r<=n)
출력:
    1. 스위치의 상태 한줄에 최대 20개(켜진1, 꺼진2)
문제:
    1. 남학생은 스위치 번호가 자기가 받은 수의 배수이면 그 스위치의 상태를 바꾼다.
    2. 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 재칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 그 구간에 속한 스위치 상태를 바꾼다.
       이때, 구간에 속한 스위치 개수는 항상 홀수
로직:
    1. 각 스위치의 상태를 배열에 저장
    2. 학생수 만큼 반복하면서
    3. 문제의 조건대로 구현
    4. 100개 이하여서 O(n^2) 으로 해도 될듯
*/

import java.io.*;
import java.util.*;

public class P1244_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] switchArr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<s; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                int k = 1;
                while(k*num <= n) {
                    switchArr[k*num] = (switchArr[k*num]+1)%2;
                    k++;
                }
            }
            else {
                int k = num-1;
                int l = num+1;
                switchArr[num] = (switchArr[num]+1)%2;
                while(k>=1 && l<=n && switchArr[k] == switchArr[l]) {
                    switchArr[k] = (switchArr[k]+1)%2;
                    switchArr[l] = (switchArr[l]+1)%2;
                    k--;
                    l++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            sb.append(switchArr[i]+" ");
            if(i!=0 && i%20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}