package model.bullet;

import model.Hitting;
import model.Living;
import model.Movable;
import model.Shooter;
import model.unit.Unit;
import model.UnitManager;
import window.WindowConfig;

import java.awt.*;

import static utils.Helpers.hasIntersect;

public abstract class Bullet extends Unit implements Movable, Hitting {

    static UnitManager unitManager = new UnitManager();

    protected Shooter shooter;
    protected float angle;
    protected float speed;
    protected int damage;
    protected int cost;

    public Bullet(float x, float y, Image image, int modelWidth, int modelHeight, float angle, Shooter shooter) {
        super(x, y, image, modelWidth, modelHeight);
        this.angle = angle;
        this.shooter = shooter;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(angle, x + modelWidth / 2.0, y + modelHeight / 2.0);
        g2.drawImage(image.getScaledInstance(modelWidth, modelHeight, Image.SCALE_SMOOTH), (int) x, (int) y, null);
        g2.rotate(-angle, x + modelWidth / 2.0, y + modelHeight / 2.0);
    }

    @Override
    public boolean checkHit(Living living) {
        return hasIntersect(this, (Unit) living);
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void move() {
        float dy = - (float) Math.cos(angle) * speed;
        float dx = (float) Math.sin(angle) * speed;
        x += dx;
        y += dy;
    }

    public void live() {
        unitManager.add(this);
    }

    public boolean isOutOfMap() {
        Dimension windowSize = WindowConfig.windowConfig();
        return x < 0 || x > windowSize.width || y < 0 || y > windowSize.height;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public int getDamage() {
        return damage;
    }
}
