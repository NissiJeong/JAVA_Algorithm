package example.test.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conferenceroom {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int confCount = sc.nextInt();
        List<Integer> sTimes = new ArrayList();
        List<Integer> eTimes = new ArrayList();
        for(int i=0; i<confCount; i++){
            sTimes.add(sc.nextInt());
            eTimes.add(sc.nextInt());
        }

        int minEndTime = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<eTimes.size(); i++){
            if(minEndTime>eTimes.get(i)){
                minEndTime = eTimes.get(i);
                minIndex = i;
            }
        }

        int count = 0;
        for(int i=0; i<sTimes.size(); i++){
            if(i==minIndex || sTimes.get(i)>=minEndTime){
                count++;
                minEndTime = eTimes.get(i);
                System.out.print(sTimes.get(i)+" "+eTimes.get(i));
                System.out.println();
            }
        }
        System.out.println(count);
    }
}
