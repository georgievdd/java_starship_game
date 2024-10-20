package model.coin;

import config.ImageLoader;
import model.UnitManager;
import model.unit.Unit;
import utils.Helpers;
import utils.Pair;
import window.WindowConfig;

import java.awt.*;

public class Coin extends Unit {
    private static final int MAX_TICKS = 10;

    private static int ticksToChangeSize;

    private float addToSize;
    private final Pair<Integer, Integer> sizeSegment;

    UnitManager unitManager = new UnitManager();

    public Coin() {
        super(Helpers.getRandomWidth(), Helpers.getRandomHeight(), ImageLoader.coin(), 25, 25);
        sizeSegment = new Pair<>(20, 30);
        addToSize = 1;
        ticksToChangeSize = 10;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image.getScaledInstance(modelWidth, modelHeight, Image.SCALE_SMOOTH), (int) x, (int) y, null);
    }

    public void live() {
        unitManager.add(this);
    }

    public boolean hasContact(Unit unit) {
        return Helpers.hasIntersect(this, unit);
    }

    public boolean isOutOfMap() {
        Dimension windowSize = WindowConfig.windowConfig();
        return x < 0 || x > windowSize.width || y < 0 || y > windowSize.height;
    }

    @Override
    public void update() {
        --ticksToChangeSize;
        if (ticksToChangeSize > 0) {
            return;
        }
        ticksToChangeSize = MAX_TICKS;

        modelWidth += addToSize;
        x -= addToSize / 2;
        modelHeight += addToSize;
        y -= addToSize / 2;
        if (modelHeight == sizeSegment.second()) {
            addToSize = -1;
        }
        if (modelWidth == sizeSegment.first()) {
            addToSize = 1;
        }
    }
}
