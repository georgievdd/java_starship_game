package window;

import config.keyboard.KeyConfiguration;
import config.keyboard.KeyboardManager;
import game.GameManager;
import model.UnitManager;
import model.bullet.Bullet;
import model.coin.Coin;
import model.coin.CoinManager;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static utils.Helpers.inHashSet;

public class GamePanel extends JPanel implements ActionListener {
    UnitManager unitManager;
    KeyboardManager keyboardManager;
    GameManager gameManager;
    CoinManager coinManager;

    public GamePanel() {
        unitManager = new UnitManager();
        keyboardManager = new KeyboardManager();
        gameManager = new GameManager();
        coinManager = new CoinManager();
        setFocusable(true);
        addKeyListener(keyboardManager);
        initPlayers();
        Timer timer = configureTimer();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        unitManager.forEach(unit -> unit.draw(g));
    }

    public void updateGame() {
        coinManager.addCoin();
        unitManager.forEach(unit -> {
            if (unit instanceof Bullet bullet) {
                if (bullet.isOutOfMap()) {
                    unitManager.addToRemoveList(bullet);
                    return;
                }
                gameManager.getLivings(bullet.getShooter()).forEach(living -> {
                    if (bullet.checkHit(living)) {
                        living.decreaseHP(bullet.getDamage());
                        unitManager.addToRemoveList(bullet);
                    }
                });
            }
            if (unit instanceof Coin coin) {
                if (coin.isOutOfMap()) {
                    unitManager.addToRemoveList(coin);
                    coinManager.removeCoin(coin);
                    return;
                }
                for (Coin otherCoin : coinManager.getCoinSet()) {
                    if (coin != otherCoin && coin.hasContact(otherCoin)) {
                        unitManager.addToRemoveList(coin);
                        coinManager.removeCoin(coin);
                        return;
                    }
                }
                gameManager.getShips().forEach(player -> {
                    if (coin.hasContact(player)) {
                        player.addCoins(5);
                        unitManager.addToRemoveList(coin);
                        coinManager.removeCoin(coin);
                    }
                });
            }
            unit.update();
        });
        unitManager.remove();
    }

    private Timer configureTimer() {
        return new Timer(10, this);
    }

    private void initPlayers() {
        Player player1 = new Player(1, new KeyConfiguration(KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_Q, KeyEvent.VK_E, KeyEvent.VK_W));
        Player player2 = new Player(2, new KeyConfiguration(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_UP));
        keyboardManager.addKeyConfiguration(player1.getKeyConfiguration());
        keyboardManager.addKeyConfiguration(player2.getKeyConfiguration());
        unitManager.add(player1.getShip());
//        unitManager.add(player2.getShip());
        gameManager.addPlayerInfo(player1.getShip(), inHashSet(player2.getShip()));
        gameManager.addPlayerInfo(player2.getShip(), inHashSet(player1.getShip()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint();
    }

}
