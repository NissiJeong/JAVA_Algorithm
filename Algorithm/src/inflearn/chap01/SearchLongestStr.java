package inflearn.chap01;

import java.util.Scanner;

public class SearchLongestStr {

    public static String solution(String str){
        String[] strArr = str.split(" ");
        
        int findIdx = 0;
        int lengh = strArr[0].length();

        for(int i=1; i<strArr.length; i++){
            if(strArr[i].length() > lengh){
                findIdx = i;
                lengh = strArr[i].length();
            }
        }
        return strArr[findIdx];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str1 = kb.nextLine();

        System.out.println(solution(str1));
    }
}
