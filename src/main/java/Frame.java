import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private boolean fullscreen = false;

    public Frame(int width, int height) {
        super();
        this.setSize(new Dimension(width, height));
        this.setTitle("Fernwartung Support");
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.setVisible(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
    }

    public void changeScreenSize() {
        dispose();
        if (fullscreen) {
            this.setExtendedState(JFrame.NORMAL);
            this.setSize(new Dimension(Consts.windowWidth, Consts.windowHeight));
            this.setUndecorated(false);
        } else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        setVisible(true);
        fullscreen = !fullscreen;
    }

}
