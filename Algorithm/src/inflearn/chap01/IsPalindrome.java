package inflearn.chap01;

import java.util.Scanner;

/*
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 */
public class IsPalindrome {

    public static String isPalindrome(String str){
        String answer = "";
        char[] chrArr = str.toCharArray();
        int lt = 0, rt = chrArr.length-1;

        while (lt < rt) {
            if(Character.toUpperCase(chrArr[lt]) != Character.toUpperCase(chrArr[rt])){
                answer = "NO";
                break;
            }
            answer = "YES";
            lt++;
            rt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(isPalindrome(str));
    }
}
