package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
조건:
1. 단어를 재배열해 다른 단어를 만들 수 있어야 한다. -> 쓰인 모든 단어의 개수가 같아야 한다.
2. 두 단어의 첫번째 글자와 마지막 글자는 동일
3. 각 단어에서 모음을 제거한 문자열은 동일 -> 모음을 제거한 단어가 동일해야 한다.
 */
public class P25178_S5_R {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(isFirstCondition(str1, str2) && isSecondCondition(str1, str2) && isThirdCondition(str1, str2) ? "YES" : "NO");
    }

    private static boolean isThirdCondition(String str1, String str2) {
        // aeiou 삭제 후 같아야 함
        String replaceA = str1.replaceAll("[aeiou]", "");
        String replaceB = str2.replaceAll("[aeiou]", "");

        return replaceA.equals(replaceB);
    }

    private static boolean isSecondCondition(String str1, String str2) {
        return (str1.charAt(0) == str2.charAt(0)) && (str1.charAt(n-1) == str2.charAt(n-1));
    }

    static boolean isFirstCondition(String str1, String str2) {
        int[] check = new int['z'-'a'+1];
        for(int i=0; i<str1.length(); i++) {
            check['z'-str1.charAt(i)]++;
            check['z'-str2.charAt(i)]--;
        }

        for(int i=0; i<check.length; i++) {
            if(check[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
