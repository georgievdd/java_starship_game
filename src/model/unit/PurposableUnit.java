package model.unit;

import model.Purposable;

import java.awt.*;

public abstract class PurposableUnit extends LivingUnit implements Purposable {
    int coins;
    public PurposableUnit(float x, float y, Image image, int modelWidth, int modelHeight, int hp) {
        super(x, y, image, modelWidth, modelHeight, hp);
        this.coins = 100;
    }

    public void addCoins(int amount) {
        coins += amount;
    }
    public int getCoins() {
        return coins;
    }
    public void decreaseCoins(int amount) {
        coins -= amount;
    }
}
