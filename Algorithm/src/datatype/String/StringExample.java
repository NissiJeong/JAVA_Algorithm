package datatype.String;

import java.util.Arrays;

public class StringExample {
    public static void main(String[] args) {
        String str1 = "example";
        char char1 = str1.charAt(0);

        System.out.println("char1 = " + char1);

        String subStr = str1.substring(0,3);
        System.out.println("subStr = " + subStr);
        System.out.println("str1 = " + str1);

        boolean startsWith = str1.startsWith("exa");
        System.out.println("startsWith = " + startsWith);

        String replaceStr = str1.replace("e", "a");
        System.out.println("replaceStr = " + replaceStr);

        String[] strArr = str1.split("");
        Arrays.stream(strArr).forEach(System.out::println);

        char[] charArr = str1.toCharArray();
        for (char c : charArr) {
            System.out.println("c = " + c);
        }
    }
}
