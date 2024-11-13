package baekjoon.bronze;

import java.util.Scanner;

public class p1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] intNums = sc.nextLine().split(" ");
        int a = Integer.parseInt(intNums[0]), b = Integer.parseInt(intNums[1]);

        if(a > b) System.out.println(">");
        if(a < b) System.out.println("<");
        if(a == b) System.out.println("==");
    }
}
