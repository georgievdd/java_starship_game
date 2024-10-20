package game;

import model.Living;
import model.Shooter;
import model.ship.Ship;

import java.util.*;

public class GameManager {
    private static final Set<Ship> ships = new HashSet<>();
    private static final Map<Shooter, Set<Living>> playersInfo = new HashMap<>();

    public void addPlayerInfo(Shooter shooter, Set<Living> livings) {
        playersInfo.put(shooter, livings);
        ships.add((Ship) shooter);
    }

    public Set<Living> getLivings(Shooter shooter) {
        return playersInfo.get(shooter);
    }

    public Set<Ship> getShips() {
        return ships;
    }
}
