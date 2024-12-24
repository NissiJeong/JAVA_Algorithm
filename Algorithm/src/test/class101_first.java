package test;

public class class101_first {
}

class Solution_1 {

    public int solution(int n) {
        int digit = 1;
        long count = 9;
        long start = 1;

        while(n > digit * count) {
            n -= digit*count;
            digit++;
            count *= 10;
            start *= 10;
        }

        long num = start + (n-1) / digit;
        int index = (n-1) % digit;

        return String.valueOf(num).charAt(index) - '0';
    }
}
