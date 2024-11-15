package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2752_B4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[3];

        numbers[0] = Integer.parseInt(st.nextToken());
        numbers[1] = Integer.parseInt(st.nextToken());
        numbers[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.print(number+" ");
        }

        Integer[] numbers2 = {1,2,4,5,6};
        Arrays.sort(numbers2, Comparator.reverseOrder());

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));

        Arrays.sort(numbers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1.compareTo(o2); //오름차순
                return o1 - o2; //오름차순
            }
        });

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));

        Arrays.sort(numbers2, (a,b) ->
            b - a //내림차순
        );

        System.out.println("Arrays.toString(numbers2) = " + Arrays.toString(numbers2));
    }
}
