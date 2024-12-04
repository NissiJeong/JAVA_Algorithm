package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 입력:
 *  1. N, K (!<=N, K<=300000)
 *  2. N개 줄 무게M, 가격V (0<=M,V<=1,000,000)
 *  3. K개 줄 가방 무게 C (1<=C<=100,000,000)
 * 출력:
 *  1. 보석 가격 합 최댓값
 * 로직:
 *  1. 보석 n개, 가방 k개, 가방에는 1개의 보석
 *  2. k개 가방에 각 c 보다 같거나 작은 최대 보석을 넣어야 한다.
 *  3. 가방 c 에 들어갈 수 있는 보물 중 가장 값비싼 보물을 찾는다.
 *      상세로직:
 *          1. treeMap.put(m,v) -> v 비교하여 큰 값 넣기
 *          2. if 키 최댓값 <= c 의 최솟값 -> v 최대 k 개 sum
 *          3. else 1..k 순회
 *          3-1.
 */
public class P1202_G2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 무게 오름차순, 무게 같으면 내림차순
        Arrays.sort(jewelries, (o1, o2) -> {
            if(o1.mass == o2.mass) {
                return o2.value - o1.value;
            }
            return o1.mass - o2.mass;
        });

        for(int i=0; i<K; i++) bags[i] = Integer.parseInt(br.readLine());
        // 가방 오름차순
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }

            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.print(sum);
    }
}

class Jewelry {

    int mass;
    int value;

    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}