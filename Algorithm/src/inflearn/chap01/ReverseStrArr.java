package inflearn.chap01;

import java.util.Scanner;

public class ReverseStrArr {

    public static String reverseStr(String str){
        String rString = "";
        char[] chArr = str.toCharArray();
        for(int i=chArr.length-1; i>=0; i--){
            rString += chArr[i];
        }

        return rString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idx = sc.nextInt();
        String[] strArr = new String[idx];
        for(int i=0; i<idx; i++){
            strArr[i] = sc.next();
        }

        for(int i=0; i<idx; i++){
            System.out.println(reverseStr(strArr[i]));
        }
    }

}
