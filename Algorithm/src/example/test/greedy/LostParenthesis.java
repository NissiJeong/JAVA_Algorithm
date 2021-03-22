package example.test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int result = 0;
        if(!exp.contains("-")){
            String[] expArr = exp.split("\\+");
            int mTotal = 0;
            for(int i=0; i< expArr.length; i++){
                mTotal += Integer.parseInt(expArr[i]);
            }
            result = mTotal;
        }else{
            String[] expArr = exp.split("-");
            int mTotal = 0;
            int ppTotal = 0;
            int pTotal = 0;
            for(int i=0; i< expArr.length; i++){
                pTotal = 0;

                String[] plusArr = expArr[i].split("\\+");
                for(String s : plusArr) {
                    if(i==0) ppTotal += Integer.parseInt(s);
                    else pTotal += Integer.parseInt(s);
                }
                mTotal += pTotal;

            }
            result = ppTotal - mTotal;
        }
        System.out.println(result);
    }
}
