package model.bullet;

import config.ImageLoader;
import model.Shooter;

public class FastBullet extends Bullet {
    public FastBullet(float x, float y, float angle, Shooter shooter) {
        super(x, y, ImageLoader.fastBullet(), 35, 35, angle, shooter);
        this.damage = 3;
        this.cost = 5;
        this.speed = 55.0f;
        live();
    }
}
