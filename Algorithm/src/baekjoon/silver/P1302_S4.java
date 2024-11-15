package baekjoon.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 문제분석
 * -
 */
public class P1302_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> bookCntMap = new HashMap<>();

        for(int i=0; i<n; i++){
            String book = br.readLine();
            bookCntMap.put(book, bookCntMap.getOrDefault(book, 0)+1);
        }

        String maxBook = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        int maxCnt = 0;
        for (String key : bookCntMap.keySet()) {
            if(maxCnt <= bookCntMap.get(key)){
                if(maxCnt == bookCntMap.get(key)){
                    if(key.compareTo(maxBook) < 0)
                        maxBook = key;
                }
                else
                    maxBook = key;

                maxCnt = bookCntMap.get(key);
            }
        }

        System.out.println(maxBook);
    }
}
