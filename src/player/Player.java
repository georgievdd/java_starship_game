package player;

import config.ImageLoader;
import config.keyboard.KeyConfiguration;
import model.bar.StateBar;
import model.ship.Ship;
import window.WindowConfig;

public class Player implements Configurable {
    private final Ship ship;
    private final StateBar stateBar;
    private final KeyConfiguration keyConfiguration;

    public Player(int id, KeyConfiguration keyConfiguration) {
        this.keyConfiguration = keyConfiguration;
        float windowWidth = WindowConfig.windowConfig().width;
        float windowHeight = WindowConfig.windowConfig().height;

        if (id == 1) {
            ship = new Ship(100f, windowHeight / 2, ImageLoader.ship(id), (float) Math.PI / 2);
            stateBar = new StateBar(1, ship);
        } else {
            ship = new Ship(windowWidth - 200f, windowHeight / 2, ImageLoader.ship(id), (float) -Math.PI / 2);
            stateBar = new StateBar(2, ship);
        }
        keyConfiguration.bind(ship);
    }

    public Ship getShip() {
        return ship;
    }

    public StateBar getStateBar() {
        return stateBar;
    }

    @Override
    public KeyConfiguration getKeyConfiguration() {
        return keyConfiguration;
    }
}
