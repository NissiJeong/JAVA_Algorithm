package baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 가장 긴 세로와 가로의 길이와 위치를 구한다.
 * 2. 가장 긴 가로의 양 옆 세로의 길이 차가 빈 사각형의 세로 길이
 * 3. 가장 긴 세로의 양 옆 가로의 길이 차가 빈 사각형의 가로 길이
 * 4. (큰 사각형 너비 - 빈 사각형 너비) * k
 */
public class p2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int lMax = 0, hMax = 0, lMaxI = 0, hMaxI = 0;

        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            arr[i] = length;

            // 1. 가장 긴 높이와 위치 구하기
            if((direction == 3 || direction == 4) && hMax < length) {
                hMax = length;
                hMaxI = i;
            }
            // 1. 가장 긴 가로와 위치 구하기
            else if((direction == 1 || direction == 2) && lMax < length) {
                lMax = length;
                lMaxI = i;
            }
        }

        int right, left, hMin, lMin;
        // 2. 빈 사각형의 세로 길이 구하기
        if(lMaxI+1 == 6) right = 0;
        else right = lMaxI + 1;

        if(lMaxI-1 == -1) left = 5;
        else left = lMaxI - 1;

        hMin = Math.abs(arr[right] - arr[left]);

        // 3. 빈 사각형의 가로 길이 구하기
        if(hMaxI+1 == 6) right = 0;
        else right = hMaxI + 1;

        if(hMaxI-1 == -1) left = 5;
        else left = hMaxI - 1;

        lMin = Math.abs(arr[right] - arr[left]);

        // 4. (큰 사각형 너비 - 빈 사각형 너비) * k
        System.out.println(((hMax * lMax) - (lMin * hMin)) * k);
    }
}
