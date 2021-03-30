package example.test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberTie2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> posList = new ArrayList<>();
        List<Long> negList = new ArrayList<>();

        for(int i=0; i<n; i++){
            Long temp = Long.parseLong(br.readLine());
            if(temp>0) posList.add(temp);
            else negList.add(temp);

        }

        posList.sort(Collections.reverseOrder());
        negList.sort(null);

        System.out.println(posList.toString());
        System.out.println(negList.toString());

        long fNum = 0;
        long sum = 0;
        if(posList.size()>0) {
            fNum = posList.get(0);
            for (int i = 1; i < posList.size(); i++) {
                if (i % 2 == 1) {
                    if(posList.get(i)!=0) sum += fNum * posList.get(i);
                    else sum += fNum + posList.get(i);
                } else {
                    fNum = posList.get(i);
                }
            }
            if (posList.size() % 2 == 1) sum += fNum;
        }

        if(negList.size()>0){
            fNum = negList.get(0);
            for(int i=1; i< negList.size(); i++){
                if(i % 2 == 1){
                    sum += fNum * negList.get(i);
                }else{
                    fNum = negList.get(i);
                }
            }
            if(negList.size() % 2 == 1) sum += fNum;
        }
        System.out.println(sum);
    }
}
