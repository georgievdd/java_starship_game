package model.bar.transfer;

import model.ship.Ship;

public class HealthTransfer extends Transfer {
    public HealthTransfer(Ship ship) {
        super(ship);
    }

    @Override
    public int getData() {
        return ship.getHP();
    }
}
