package inflearn.chap01;

import java.util.Scanner;

public class SearchString {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();

        int cnt = 0;
        for(int i=0; i<input1.length(); i++){
            if(Character.toString(input1.charAt(i)).toUpperCase().equals(input2.toUpperCase())){
                cnt++;
            }
        }

        System.out.println(cnt);
        
        return ;
      }
}
