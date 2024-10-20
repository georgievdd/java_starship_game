package model.bullet;

import config.ImageLoader;
import model.Shooter;

public class HeavyBullet extends Bullet {
    public HeavyBullet(float x, float y, float angle, Shooter shooter) {
        super(x, y, ImageLoader.heavyBullet(), 50, 50, angle, shooter);
        this.damage = 20;
        this.cost = 50;
        this.speed = 10.0f;
        live();
    }
}
