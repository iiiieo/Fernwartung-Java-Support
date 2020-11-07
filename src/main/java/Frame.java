import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private boolean fullscreen = false;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ScreenPanel screenPanel;

    public Frame(int width, int height) {
        super();
        this.setSize(new Dimension(width, height));
        this.setTitle("Fernwartung Support");
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setFocusTraversalKeysEnabled(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(new KeyHandlerPanel());

        this.screenPanel = new ScreenPanel(9661);
        this.screenPanel.setBounds(0,0,this.getWidth(), this.getHeight());
        this.add(screenPanel);

        this.setVisible(true);
    }

    public void changeScreenSize() {
        dispose();
        if (fullscreen) {
            this.setExtendedState(JFrame.NORMAL);
            this.setSize(800, 600);
            this.setUndecorated(false);
        } else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        setVisible(true);
        fullscreen = !fullscreen;
    }

    public ScreenPanel getScreenPanel() {
        return screenPanel;
    }

    public void setScreenPanel(ScreenPanel screenPanel) {
        this.screenPanel = screenPanel;
    }
}
