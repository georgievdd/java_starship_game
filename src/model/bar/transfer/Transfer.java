package model.bar.transfer;

import model.ship.Ship;

public abstract class Transfer {
    Ship ship;

    public Transfer(Ship ship) {
        this.ship = ship;
    }

    public abstract int getData();
}
