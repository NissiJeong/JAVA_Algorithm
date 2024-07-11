package inflearn.chap01;

import java.util.*;
/*
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 */
public class FindInteger {
    public int solution(String s){
		int answer=0;
		//String answer="";
		for(char x : s.toCharArray()){
			if(x>=48 && x<=57) answer=answer*10+(x-48);
			/*if(Character.isDigit(x)){
				answer=answer*10+ Character.getNumericValue(x);
			}*/
			
		}
		//return Integer.parseInt(answer);
        return answer;
	}

    public static String findInteger(String str){
        String answer = "";
        char[] chrArr = str.toCharArray();

        for(char x : chrArr) 
            if(Character.isDigit(x)) answer += x;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(Integer.parseInt(findInteger(str)));
    }
}
