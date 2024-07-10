package inflearn.chap01;

import java.util.Scanner;

public class ReverseSomeStr {

    public static String reverseStr(String str){
        String answer = "";
        char[] chrArr = str.toCharArray();
        int lt = 0, rt = chrArr.length-1;

        while (lt < rt) {
            if(!Character.isAlphabetic(chrArr[lt])) lt++;
            else if(!Character.isAlphabetic(chrArr[rt])) rt--;
            else {
                char temp = chrArr[lt];
                chrArr[lt] = chrArr[rt];
                chrArr[rt] = temp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(chrArr);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(reverseStr(str));
    }
}
