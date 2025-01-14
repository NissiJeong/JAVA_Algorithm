package programers;

import java.util.*;

public class 가사검색 {
    static Map<Integer, List<String>> wordsByLength = (Map<Integer, List<String>>) new HashMap<Integer, List<String>>();
    static Map<Integer, List<String>> reverseWordsByLength = (Map<Integer, List<String>>) new HashMap<Integer, List<String>>();

    public int[] solution(String[] words, String[] queries) {
        for(String word : words) {
            int len = word.length();
            wordsByLength.putIfAbsent(len, new ArrayList<>());
            reverseWordsByLength.putIfAbsent(len, new ArrayList<>());

            wordsByLength.get(len).add(word);
            reverseWordsByLength.get(len).add(new StringBuilder(word).reverse().toString());
        }

        for(int len : wordsByLength.keySet()) {
            Collections.sort(wordsByLength.get(len));
            Collections.sort(reverseWordsByLength.get(len));
        }

        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if(query.charAt(0) == '?') {
                String reversedQuery = new StringBuilder(query).reverse().toString();
                answer[i] = countMatches(reversedQuery, reverseWordsByLength.getOrDefault(len, new ArrayList<>()));
            } else {
                answer[i] = countMatches(query, wordsByLength.getOrDefault(len, new ArrayList<>()));
            }
        }

        return answer;
    }

    private int countMatches(String query, List<String> list) {
        String startQuery = query.replace('?','a');
        String endQuery = query.replace('?', 'z');

        int startIdx = lowerBound(list, startQuery);
        int endIdx = upperBound(list, endQuery);

        return endIdx - startIdx;
    }

    private int lowerBound(List<String> list, String target) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(list.get(mid).compareTo(target) >= 0) hi = mid;
            else lo = mid+1;
        }

        return lo;
    }

    private int upperBound(List<String> list, String target) {
        int lo = 0, hi = list.size();
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(list.get(mid).compareTo(target) > 0) hi = mid;
            else lo = mid+1;
        }

        return lo;
    }
}