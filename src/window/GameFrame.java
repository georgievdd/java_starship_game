package window;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() throws HeadlessException {
        super();
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        configureFrame();
    }

    private void configureFrame() {
        Dimension win = WindowConfig.windowConfig();
        setBounds(0, 0, win.width, win.height);
        setVisible(true);
    }
}