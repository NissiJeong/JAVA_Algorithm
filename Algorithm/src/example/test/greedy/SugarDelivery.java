package example.test.greedy;

import java.io.IOException;
import java.util.Scanner;

public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value = sugar(n);
        System.out.println(value);
    }
    public static int sugar(int n){
        int temp = n / 5;
        int temp1 = n % 5;
        for(int i=temp; i>=0; i--){
            if((n-(i*5)) % 3 == 0 && i != 0){
                int returnValue = i + ((n-(5*i))/3);
                return returnValue;
            }else if(i==0 && n%3 == 0){
                return n/3;
            }
        }
        return -1;
    }
}
