package window;

import model.Drawable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class UnitManager {
    private final static List<Drawable> units = new ArrayList<>();
    private final static List<Drawable> unitsToRemove = new ArrayList<>();
    public UnitManager() {}

    public void add(Drawable e) {
        units.add(e);
    }
    public void addToRemoveList(Drawable e) {
        unitsToRemove.add(e);
    }

    public void remove() {
        unitsToRemove.forEach(units::remove);
        unitsToRemove.clear();
    }
    public void extend(Collection<Drawable> drawables) {
        units.addAll(drawables);
    }
    public void forEach(Consumer<Drawable> fun) {
        units.forEach(fun);
    }
}