package example.test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NewRecruits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());

        List<int[][]> testList = new ArrayList();

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];

            StringTokenizer st;
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine()," ");
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            testList.add(score);
        }


        for(int[][] a : testList){
            int sMin = a[0][1];
            int fMin = -1;
            int count = 0;
            int[] minIndex = new int[a.length];
            for(int i=0; i<a.length; i++){
                if(a[i][1] > sMin){
                    count++;
                    minIndex[i] = i;
                }else{
                    minIndex[i] = -1;
                }
                if(a[i][1] == 1) fMin = a[i][0];
            }
            for(int i=0; i<a.length; i++){
                if(a[i][0] > fMin && !Arrays.asList(minIndex).contains(i)){
                    count++;
                }
            }
            System.out.println(a.length - count);
        }


    }
}
