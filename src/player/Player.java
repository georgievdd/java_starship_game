package player;

import config.ImageLoader;
import config.keyboard.KeyConfiguration;
import model.ship.Ship;

public class Player implements Configurable {
    private final Ship ship;
    private final KeyConfiguration keyConfiguration;

    public Player(int id, KeyConfiguration keyConfiguration) {
        this.keyConfiguration = keyConfiguration;
        ship = new Ship(100.0d * id, 100.0d * id, ImageLoader.ship(id), (float) Math.PI / 2);
        keyConfiguration.bind(ship);
    }

    public Ship getShip() {
        return ship;
    }


    @Override
    public KeyConfiguration getKeyConfiguration() {
        return keyConfiguration;
    }
}
