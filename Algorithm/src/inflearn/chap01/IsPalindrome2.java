package inflearn.chap01;

import java.util.*;

/*
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
알파벳 이외의 문자들의 무시합니다.

found7, time: study; Yduts; emit, 7Dnuof
 */
public class IsPalindrome2 {

    public String solution(String s){
		String answer = "NO";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp = new StringBuilder(s).reverse().toString();
		if(s.equals(tmp)) answer = "YES";
		return answer;
	}

    public static String isPalindrome(String str){
        String answer = "YES";
        char[] chrArr = str.toCharArray();
        int lt = 0, rt = chrArr.length - 1;

        while (lt < rt) {
            if(!Character.isAlphabetic(chrArr[lt])) lt++;
            else if(!Character.isAlphabetic(chrArr[rt])) rt--;
            else {
                if(Character.toUpperCase(chrArr[lt]) != Character.toUpperCase(chrArr[rt])) {
                    answer = "NO";
                    break;
                }
                lt++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(isPalindrome(str));
    }
}
