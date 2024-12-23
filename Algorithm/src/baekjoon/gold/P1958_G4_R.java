package baekjoon.gold;

import java.io.*;

public class P1958_G4_R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int l1 = str1.length();
        int l2 = str2.length();
        int l3 = str3.length();

        int[][][] dp = new int[l1+1][l2+1][l3+1];
        for(int i=1; i<=l1; i++) {
            for(int j=1; j<=l2; j++) {
                for(int k=1; k<=l3; k++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str1.charAt(i-1) == str3.charAt(k-1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    }
                    else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }
}