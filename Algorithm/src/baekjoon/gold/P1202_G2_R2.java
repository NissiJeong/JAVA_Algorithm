package baekjoon.gold;

import java.io.*;
import java.util.*;

public class P1202_G2_R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry2[] arr1 = new Jewelry2[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = new Jewelry2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] arr2 = new int[K];
        for(int i=0; i<K; i++) {
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr1, (o1, o2) -> {
            if(o1.weight == o2.weight) return o2.value - o1.value;
            return o1.weight - o2.weight;
        });

        Arrays.sort(arr2);

        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0,j=0; i<K; i++) {
            while(j<N && arr1[j].weight <= arr2[i]) {
                pq.offer(arr1[j++].value);
            }

            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}

class Jewelry2 {
    int weight,value;

    Jewelry2(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
