package inflearn.chap01;

import java.util.*;

/*
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 */
public class FindShortestLengh {

    public static String findShortestLengh(String str, String key){
        int[] answer = new int[str.length()];
        char[] chrArr = str.toCharArray();
        int p = 1001;

        for(int i=0; i<chrArr.length; i++){
            if(String.valueOf(chrArr[i]).equals(key))
                p = 0;
            else
                p++;

            answer[i] = p;
        }

        p = 1000;

        for(int i=chrArr.length-1; i>=0; i--){
            if(String.valueOf(chrArr[i]).equals(key))
                p = 0;
            else
                p++;

            if(answer[i] > p)
                answer[i] = p;
        }

        String answer2 = "";
        for(int x : answer)
            answer2 += x+ " ";
        return answer2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String key = sc.next();
        System.out.println(findShortestLengh(str, key));
    }
}
