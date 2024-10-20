package model.unit;

import model.Living;

import java.awt.*;

abstract public class LivingUnit extends Unit implements Living {
    int hp;
    public LivingUnit(double x, double y, Image image, int modelWidth, int modelHeight, int hp) {
        super(x, y, image, modelWidth, modelHeight);
        this.hp = hp;
    }

    public void decreaseHP(int hp) {
        this.hp -= hp;
        System.out.println("Decreasing: " + hp);
    }

    public int getHP() {
        return hp;
    }
}
