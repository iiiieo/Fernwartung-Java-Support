import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandlerPanel implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
        if(e.getKeyCode() == KeyEvent.VK_F11){
            Main.getMain().getFrame().changeScreenSize();
            System.out.println("change");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
