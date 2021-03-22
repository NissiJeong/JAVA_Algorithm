package example.test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ropes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i=0; i<N; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        int[] count = new int[N];
        for(int i=0; i<N; i++){
            count[i] = ropes[i]*(N-i);
        }

        int max = -1;
        for(int i=0; i<N; i++){
            if(max < count[i]){
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
