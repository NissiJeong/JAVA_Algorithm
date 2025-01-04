package baekjoon.silver;

import java.io.*;
import java.util.*;

public class P18870_S2_another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            treeSet.add(k);
        }

        List<Integer> list = new ArrayList<>(treeSet);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int index = Collections.binarySearch(list, arr[i]);
            sb.append(index).append(" ");
        }

        System.out.println(sb);
    }
}
