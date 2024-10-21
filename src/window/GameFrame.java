package window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    public GameFrame() throws HeadlessException {
        super();
        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        configureExit(gamePanel);
        configureFrame();
    }

    private void configureFrame() {
        Dimension win = WindowConfig.windowConfig();

        setUndecorated(true);
        setBounds(0, 0, win.width, win.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void configureExit(GamePanel gamePanel) {
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke("ESCAPE");
        Action escapeAction = new AbstractAction() {
            @Override
            public boolean accept(Object sender) {
                return super.accept(sender);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        };

        gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "escapeKey");
        gamePanel.getActionMap().put("escapeKey", escapeAction);
    }
}