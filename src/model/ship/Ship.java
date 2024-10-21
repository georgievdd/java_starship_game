package model.ship;

import model.Controllable;
import model.Movable;
import model.Shooter;
import model.bullet.FastBullet;
import model.bullet.HeavyBullet;
import model.unit.PurposableUnit;
import window.WindowConfig;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ship extends PurposableUnit implements Movable, Controllable, Shooter {
    float angle;
    float speed;
    float angleRelease;
    private ScheduledExecutorService scheduler;

    public Ship(float x, float y, Image image, float angle) {
        super(x, y, image, 100, 100, 100);
        this.angle = angle;
        this.speed = 4.0f;
        this.angleRelease = 0;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(angle, x + modelWidth / 2.0, y + modelHeight / 2.0);
        g2.drawImage(image.getScaledInstance(modelWidth, modelHeight, Image.SCALE_SMOOTH), (int) x, (int) y, null);
        g2.rotate(-angle, x + modelWidth / 2.0, y + modelHeight / 2.0);
    }

    @Override
    public void update() {
        angle += angleRelease;
        move();
    }

    @Override
    public void move() {
        float dy = - (float) Math.cos(angle) * speed;
        float dx = (float) Math.sin(angle) * speed;

        float nx = x + dx;
        float ny = y + dy;

        if (0 <= nx && nx + modelWidth <= WindowConfig.windowConfig().width) {
            x = nx;
        }
        if (0 <= ny && ny + modelHeight <= WindowConfig.windowConfig().height) {
            y = ny;
        }
    }

    @Override
    public void onStartRight() {
        angleRelease = (float) (Math.PI / 45);
    }

    @Override
    public void onStartLeft() {
        angleRelease = (float) (- Math.PI / 45);
    }

    @Override
    public void onEndRight() {
        angleRelease = 0;
    }

    @Override
    public void onEndLeft() {
        angleRelease = 0;
    }

    @Override
    public void onShootFast() {
        if (getCoins() < 2) {
            return;
        }
        decreaseCoins(2);
        new FastBullet(x, y + modelHeight / 2, angle, this);
    }

    @Override
    public void onShootHeavy() {
        if (getCoins() < 1) {
            return;
        }
        decreaseCoins(1);
        new HeavyBullet(x, y + modelHeight / 2, angle, this);
    }

    @Override
    public void onBoost() {
        if (getCoins() < 10) return;
        decreaseCoins(10);
        speed = 8.0f;
        scheduler.schedule(() -> {
            speed = 4.0f;
            scheduler.shutdown();
        }, 2, TimeUnit.SECONDS);
    }
}
