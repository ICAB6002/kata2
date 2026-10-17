package software.ulpgc.katas.logic;

import software.ulpgc.katas.model.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameProcessor {
    public Map<String, Integer> countByPlatform(List<Game> games) {
        Map<String, Integer> counts = new HashMap<>();
        for (Game game : games) {
            counts.put(game.platform(), counts.getOrDefault(game.platform(), 0) + 1);
        }
        return counts;
    }
}