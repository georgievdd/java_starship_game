package model.bar;

import config.ImageLoader;
import model.bar.transfer.CoinTransfer;
import model.bar.transfer.HealthTransfer;
import model.bar.transfer.Transfer;
import model.ship.Ship;
import model.unit.Unit;
import window.WindowConfig;

public class StateBar {
    public static int width, height;
    private final State hearthBar, coinBar;

    public StateBar(int id, Ship ship) {
        int windowWidth = WindowConfig.windowConfig().width;
        int windowHeight = WindowConfig.windowConfig().height;

        Transfer hpTransfer = new HealthTransfer(ship), coinTransfer = new CoinTransfer(ship);

        if (id == 1) {
            hearthBar = new State(0, 0, ImageLoader.hearth(), 50, 50, hpTransfer);
            coinBar = new State(0, 50, ImageLoader.coin(), 50, 50, coinTransfer);
        } else {
            hearthBar = new State(windowWidth - 100, 0, ImageLoader.hearth(), 50, 50, hpTransfer);
            coinBar = new State(windowWidth - 100, 50, ImageLoader.coin(), 50, 50, coinTransfer);
        }
    }

    public Unit getHearthBar() {
        return hearthBar;
    }

    public Unit getCoinBar() {
        return coinBar;
    }
}


