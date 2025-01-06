package baekjoon.gold;

/*
입력:
    1. N K (1<=N,k<=300000)
    2. N개의 줄 보석 정보(0<=M,V<=1000000)
    3. 최대무개 C(1<=C<=100000000)
출력:
    1. 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값 출력
문제:
    1. 가방에는 최대 한개의 보석
    2. K개의 가방에 최대 무게 C 만큼 보석을 넣을 수 있음
    3. 최대 가격을 구하는 프로그램
로직:
    1. 가벼워도 비싼 보석 먼저
    2. 아무리 비싸도 최대 무게 C 를 넘어갈 수 없음
    3. C보다 작은 애들 중 비싼 보석을 추려내야 함.
*/
import java.io.*;
import java.util.*;

public class P1202_G2_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});
        }

        int[] bags = new int[K];
        for(int i=0; i<K; i++) bags[i] = Integer.parseInt(br.readLine());

        list.sort((arr1, arr2) -> {
            if(arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            }
            return arr1[0]-arr2[0];
        });
        Arrays.sort(bags);

        long sum = 0;
        for(int i=0; i<K; i++) {
            int index = upperBound(list, bags[i]);
            sum += list.get(index)[1];
        }

        System.out.println(sum);
    }

    static int upperBound(List<int[]> list, int key) {
        int lo = 0;
        int hi = list.size();

        while(lo < hi) {
            int mid = lo+(hi-lo)/2;
            if(list.get(mid)[0] > key && list.get(mid)[2] != 1) hi = mid;
            else lo = mid+1;
        }

        list.get(lo)[2] = 1;
        return lo;
    }
}
