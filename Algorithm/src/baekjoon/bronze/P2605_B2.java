package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제분석
 * - 1부터 주어진 숫자 n 까지 줄을 세운다.
 * - 줄을 세울때 2번째로 주어진 n 개의 숫자들만큼 앞으로 이동한다.
 *
 * 문제풀이
 * -
 */
public class P2605_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numList = new ArrayList<>();

        for(int i=1; i<=n; i++){
            int lineNum = Integer.parseInt(st.nextToken());
            numList.add(i-lineNum-1, i);
        }

        for(int i : numList) System.out.print(i + " ");
    }
}
