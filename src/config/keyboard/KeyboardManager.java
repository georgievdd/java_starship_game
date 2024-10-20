package config.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyboardManager implements KeyListener {

    static Set<KeyConfiguration> keyConfigurations = new HashSet<>();
    private final Set<Integer> pressed = new HashSet<>();

    public void addKeyConfiguration(KeyConfiguration configuration) {
        keyConfigurations.add(configuration);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
        keyConfigurations.forEach(keyConfiguration -> {
            if (keyConfiguration.has(e)) {
                keyConfiguration.getCallback(e).first().run();
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyCode());
        keyConfigurations.forEach(keyConfiguration -> {
            if (keyConfiguration.has(e)) {
                if (keyConfiguration.type(e) == EventType.MULTIPLE) {
                    keyConfiguration.getCallback(e).second().run();
                }
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
