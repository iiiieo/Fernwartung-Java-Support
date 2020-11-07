import org.json.JSONObject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandlerPanel implements MouseListener {
    private ScreenPanel panel;
    public MouseHandlerPanel(ScreenPanel panel){
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = (int)(e.getX() * panel.getFactor());
        int y = (int)(e.getY() * panel.getFactor());
        JSONObject json = new JSONObject();
        json.put("socketId", panel.getSocketId());
        json.put("mouseX", x);
        json.put("mouseY", y);
        Main.getMain().getConnection().getEmitter().emit("moveMouse", json);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
