package inflearn.chap01;

import java.util.*;

/*
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
단 반복횟수가 1인 경우 생략합니다.
 */
public class ZipStr {

    public static String zipStr(String str){
        String answer = "";
        str = str + " ";
        char[] chrArr = str.toCharArray();
        char p = str.charAt(0);
        int r = 1;
        
        for(int i=1; i<chrArr.length; i++){
            if(p == chrArr[i]){
                r++;
            }
            else if(p != chrArr[i]){
                answer += p + "" +r;
                p = chrArr[i];
                r = 1;
            }
        }

        return answer.replaceAll("1", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(zipStr(str));
    }
}
