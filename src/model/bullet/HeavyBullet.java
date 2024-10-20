package model.bullet;

import config.ImageLoader;
import model.Shooter;

public class HeavyBullet extends Bullet {
    public HeavyBullet(double x, double y, double angle, Shooter shooter) {
        super(x, y, ImageLoader.heavyBullet(), 50, 50, angle, shooter);
        this.damage = 20;
        this.cost = 50;
        this.speed = 10.0d;
        live();
    }
}
