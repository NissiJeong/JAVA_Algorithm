package inflearn.chap01;

import java.util.Scanner;

public class ChangeStrCase {

    public static String soluction(String str){

        String rString = "";
        for(char a : str.toCharArray()){
            if(Character.isLowerCase(a)){
                rString += Character.toString(a).toUpperCase();
            }
            else{
                rString += Character.toString(a).toLowerCase();
            }
        }
        return rString;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();

        System.out.println(soluction(str1));
    }
}
