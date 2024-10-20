package model.unit;

import model.Drawable;

import java.awt.*;

public abstract class Unit implements Drawable {
    public double x;
    public double y;
    public int modelWidth;
    public int modelHeight;
    public Image image;

    public Unit(double x, double y, Image image, int modelWidth, int modelHeight) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.modelWidth = modelWidth;
        this.modelHeight = modelHeight;
    }
}
