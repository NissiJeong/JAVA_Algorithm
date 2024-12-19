package baekjoon.silver;

import java.io.*;

public class P1541_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] operations = br.readLine().split("-");
        int sum = 0;
        int temp = 0;

        String[] firstArr = operations[0].split("\\+");
        for(int j=0; j<firstArr.length; j++) {
            sum += Integer.parseInt(firstArr[j]);
        }
        for(int i=1; i<operations.length; i++) {
            String[] plusArr = operations[i].split("\\+");
            for(int j=0; j<plusArr.length; j++) {
                temp += Integer.parseInt(plusArr[j]);
            }
        }

        sum -= temp;

        System.out.println(sum);
    }
}
