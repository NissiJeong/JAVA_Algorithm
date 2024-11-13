//package programers;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.*;
//
//public class RunPositionChange {
//    public String[] solution(String[] players, String[] callings) {
//        Map<String, Integer> playerRankMap = this.changePlayRankingForMap(players);
//
//        for (int i = 0; i < callings.length; i++) {
//            String callingPlayer = callings[i];
//            if (playerRankMap.containsKey(callingPlayer)) {
//                int currentPlayerRank = playerRankMap.get(callingPlayer);
//                for (int j = currentPlayerRank; j > (currentPlayerRank - 1); j--) {
//                    playerRankMap.put(players[j-1], j);
//                    playerRankMap.put(players[j], j-1);
//
//                    String previousPlayer = players[j-1];
//                    players[j-1] = players[j];
//                    players[j] = previousPlayer;
//                }
//            }
//        }
//        return players;
//    }
//
//    // 학생 랭킹을 먼저 map을 이용하여 관리한다. 빠르게 검색하기 위하여
//    private Map<String, Integer> changePlayRankingForMap(String[] players) {
//
//        Map<String, Integer> map = (Map) new HashMap<String, Integer>();
//
//        for(int i=0; i<players.length; i++){
//            map.put(players[i], i);
//        }
//
//        return map;
//
//        /*
//        return IntStream.range(0, players.length)
//                .boxed()
//                .collect(Collectors.toMap(i -> players[i], i -> i));
//         */
//
//    }
//
//    public static void main(String[] args) {
//        String str = "123123123";
//
//        Character.toString(0);
//
//        char[] ccc = {'c','d','e','f'};
//
//        System.out.println(("00"+(Integer.parseInt("03")-1)).substring(1));
//
//        List<Integer> answer = new ArrayList<Integer>();
//        answer.add(1);
//        answer.add(7);
//        answer.add(2);
//
//        answer.sort((o1, o2) -> o1 - 02);
//
//        int[] a = answer.stream().sorted((o1, o2) -> o1 - o2).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();
//
//        for(int i : a){
//            System.out.println(i);
//        }
//    }
//}
