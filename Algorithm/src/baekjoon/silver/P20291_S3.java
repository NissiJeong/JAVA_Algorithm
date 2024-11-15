package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 문제분석
 * - 주어진 N개 파일의 확장자의 정렬과 개수 필요
 *
 * 문제풀이
 * - N개이 String 배열을 만들어서 확장자만 추출 후 담아 놓는다
 * - 확장자 배열을 오름차순 정리
 * - 두개의 List 를 만들어서 String 배열 반복문을 돌면서
 * - 1개의 list 에는 단어를 다른 1개에는 count 를 저장
 */
public class P20291_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> extList = new ArrayList<>();
        Map<String, Integer> extMap = new HashMap<>();

        // 한줄씩 받아서 확장자 map 에 담기, 담으면서 count 실행
        // map에 담으며 자동으로 중복 제거
        for(int i=0; i<n; i++){
            String fileName = br.readLine();
            String ext = fileName.substring(fileName.indexOf(".")+1);
            extMap.put(ext, extMap.getOrDefault(ext, 0)+1);
        }

        // map의 키 값들 list에 저장
        extList.addAll(extMap.keySet());

        // 정렬
        extList.sort(Comparator.naturalOrder());

        for(String ext : extList) System.out.println(ext + " " + extMap.get(ext));
    }
}
