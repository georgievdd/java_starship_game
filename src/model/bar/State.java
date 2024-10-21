package model.bar;

import model.bar.transfer.Transfer;
import model.unit.Unit;

import java.awt.*;

class State extends Unit {
    private final Transfer transfer;

    public State(float x, float y, Image image, int modelWidth, int modelHeight, Transfer transfer) {
        super(x, y, image, modelWidth, modelHeight);
        this.transfer = transfer;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image.getScaledInstance(modelWidth, modelHeight, Image.SCALE_SMOOTH), (int) x, (int) y, null);
        g2.drawString(((Integer) transfer.getData()).toString(), x + 50, y + 50);
    }

    @Override
    public void update() {}
}