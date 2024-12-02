package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 입력
 *  1. 테스트 케이스 t
 *  2. N, M
 * 출력
 *  1. 한줄에 하나씩 승자 출력(S, B)
 * 로직
 *  1. 우선순위 큐에 N, M 개의 데이터를 저장
 *  2. 각 peek 값을 비교하여 작은 애 죽여(poll)
 *  3. 다 비면 지는것
 */
public class P1524_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> nPq = new PriorityQueue<>();
            PriorityQueue<Integer> mPq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++) nPq.add(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) mPq.add(Integer.parseInt(st.nextToken()));

            while(!nPq.isEmpty() && !mPq.isEmpty()) {
                if(Objects.equals(nPq.peek(), mPq.peek())) mPq.poll();
                else if(nPq.peek() < mPq.peek()) nPq.poll();
                else mPq.poll();
            }

            if(nPq.isEmpty()) bw.write("B\n");
            else bw.write("S\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
