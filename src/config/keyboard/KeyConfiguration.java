package config.keyboard;

import model.Controllable;
import utils.Pair;

import java.awt.event.KeyEvent;
import java.util.*;

public class KeyConfiguration {

    private Map<Integer, EventType> type;
    private Map<Integer, Pair<Runnable, Runnable>> map;
    private List<Integer> list;
    public KeyConfiguration(Integer onRight, Integer onLeft, Integer onShootFast, Integer onShootHeavy, Integer onBoost) {
        list = new ArrayList<>();
        list.add(onRight);
        list.add(onLeft);
        list.add(onShootFast);
        list.add(onShootHeavy);
        list.add(onBoost);

        type = new HashMap<>();
        type.put(onRight, EventType.MULTIPLE);
        type.put(onLeft, EventType.MULTIPLE);
        type.put(onShootFast, EventType.SIMPLE);
        type.put(onShootHeavy, EventType.SIMPLE);
        type.put(onBoost, EventType.SIMPLE);
    }

    public void bind(Controllable controllable) {
        map = new HashMap<>();
        map.put(list.get(0), new Pair<>(controllable::onStartRight, controllable::onEndRight));
        map.put(list.get(1), new Pair<>(controllable::onStartLeft, controllable::onEndLeft));
        map.put(list.get(2), new Pair<>(controllable::onShootFast, null));
        map.put(list.get(3), new Pair<>(controllable::onShootHeavy, null));
        map.put(list.get(4), new Pair<>(controllable::onBoost, null));
        list.clear();
    }

    public boolean has(KeyEvent event) {
        return map.containsKey(event.getKeyCode());
    }

    public EventType type(KeyEvent event) {
        return type.get(event.getKeyCode());
    }

    public Pair<Runnable, Runnable> getCallback(KeyEvent event) {
        return map.get(event.getKeyCode());
    }
}
