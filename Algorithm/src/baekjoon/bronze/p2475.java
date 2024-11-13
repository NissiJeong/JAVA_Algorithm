package baekjoon.bronze;

import java.util.Scanner;

public class p2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");

        long validateNum = 0;
        for (String num : nums) {
            validateNum += Long.parseLong(num) * Long.parseLong(num);
        }

        System.out.println(validateNum % 10L);
    }
}
