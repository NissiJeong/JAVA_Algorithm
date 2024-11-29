package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 거인 나라의 인구수 n, 센티 키를 나타내는 정수 h, 뿅망치 횟수 제한 t
 *  2. n 개의 각 거인의 키
 * 출력
 *  1. 마법의 뿅망치의 횟수를 이용하여 거인들의 키를 센티보다 낮게 할 수 있는지? 최소 횟수
 *     혹은 할 수 없으면 NO, 가장 큰 거인의 키
 * 로직:
 *  1. 1..n -> 우선순위 큐를 이용하여 거읜의 키를 다 담아놓고
 *  2. 1..t -> 가장 높은 거인의 키를 줄여서 다시 넣는다
 *  3. 반복 중간에 가장 높은 거인의 키가 센티보다 작다면 YES 인 것이고 그 때 카운트를 출력
 *  3-1. 반복을 끝냈을 때 센티보다 키가 큰 거인이 있다면 NO, 가장 키 큰 거인의 키 출력
 */
public class P19638_S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> hPq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) hPq.add(Long.parseLong(br.readLine()));

        int count = 0;
        for(int i=0; i<t; i++) {
            if(hPq.peek() < centi) break;

            long highest = hPq.poll();
            if(highest != 1)
                highest /= 2;

            hPq.add(highest);
            count++;
        }

        if(hPq.peek() < centi) {
            bw.write("YES\n");
            bw.write(count+"");
        }
        else {
            bw.write("NO\n");
            bw.write(hPq.peek()+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
