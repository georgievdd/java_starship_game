package model.coin;

import java.util.HashSet;
import java.util.Set;

public class CoinManager {
    private static final Set<Coin> coinSet = new HashSet<>();
    private static final int MAX_COINS = 10;
    private static final int MAX_TICKS = 300;

    private static int coins;
    private static int ticksToAddCoin;

    public CoinManager() {
        coins = 0;
        ticksToAddCoin = 0;
    }

    public void addCoin() {
        --ticksToAddCoin;
        if (ticksToAddCoin <= 0) {
            if (coins < MAX_COINS) {
                ++coins;
                Coin coin = new Coin();
                coin.live();
                coinSet.add(coin);
            }
            ticksToAddCoin = MAX_TICKS;
        }
    }

    public void removeCoin(Coin coin) {
        coinSet.remove(coin);
        if (coins > 0) {
            --coins;
        }
    }

    public Set<Coin> getCoinSet() {
        return coinSet;
    }
}
