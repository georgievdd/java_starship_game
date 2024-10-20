package game;

import model.Living;
import model.Shooter;

import java.util.*;

public class GameManager {
    private static Map<Shooter, Set<Living>> playersInfo = new HashMap<>();

    public void addPlayerInfo(Shooter shooter, Set<Living> livings) {
        playersInfo.put(shooter, livings);
    }

    public Set<Living> getLivings(Shooter shooter) {
        return playersInfo.get(shooter);
    }
}
