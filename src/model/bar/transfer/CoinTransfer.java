package model.bar.transfer;

import model.ship.Ship;

public class CoinTransfer extends Transfer {
    public   CoinTransfer(Ship ship) {
        super(ship);
    }

    @Override
    public int getData() {
        return ship.getCoins();
    }
}
