package programers;

import java.util.Map;
import java.util.stream.*;

public class RunPositionChange {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRankMap = this.changePlayRankingForMap(players);

        for (int i = 0; i < callings.length; i++) {
            String callingPlayer = callings[i];
            if (playerRankMap.containsKey(callingPlayer)) {
                int currentPlayerRank = playerRankMap.get(callingPlayer);
                for (int j = currentPlayerRank; j > (currentPlayerRank - 1); j--) {
                    playerRankMap.put(players[j-1], j);
                    playerRankMap.put(players[j], j-1);

                    String previousPlayer = players[j-1];
                    players[j-1] = players[j];
                    players[j] = previousPlayer;
                }
            }
        }
        return players;
    }

    // 학생 랭킹을 먼저 map을 이용하여 관리한다. 빠르게 검색하기 위하여
    private Map<String, Integer> changePlayRankingForMap(String[] players) {
        
        Map<String, Integer> map = (Map) new HashMap<String, Integer>();

        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }

        return map;
        
        /*
        return IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(i -> players[i], i -> i));
         */
    }
}
