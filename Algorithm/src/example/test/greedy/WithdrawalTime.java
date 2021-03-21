package example.test.greedy;

import java.io.IOException;
import java.util.Scanner;

public class WithdrawalTime {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int pNum = sc.nextInt();
        int[] timeArr = new int[pNum];
        for(int i=0;i<pNum; i++){
            int temp = sc.nextInt();
            timeArr[i] = temp;
        }
        int calcTime = timeCalc(pNum,timeArr);
        System.out.println(calcTime);
    }
    public static int timeCalc(int pNum, int[] timeArr){
        int totalTime = 0;
        int plusTime = 0;

        for(int i=0;i<timeArr.length;i++){
            for(int j=i+1; j<timeArr.length; j++){
                if(timeArr[i] > timeArr[j]){
                    int temp = timeArr[i];
                    timeArr[i] = timeArr[j];
                    timeArr[j] = temp;
                }
            }
        }

        for(int i=0; i<timeArr.length; i++){
            for(int j=0; j<=i; j++){
                totalTime += timeArr[j];
            }
        }

        return totalTime;
    }
}
