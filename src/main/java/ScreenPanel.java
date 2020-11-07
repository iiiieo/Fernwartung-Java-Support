import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ScreenPanel extends JLabel {
    private BASE64Decoder decoder;
    private BufferedImage currentFrame;
    private int shortId;
    private String socketId= "sjobvFDqPCvv2J4PAAAB";
    private double factor;

    public ScreenPanel(int shortId){
        this.shortId = shortId;
        this.addMouseListener(new MouseHandlerPanel(this));
        decoder = new BASE64Decoder();
    }

    public void paint(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        if(currentFrame != null){
            factor = (currentFrame.getWidth()/this.getWidth());
            int frameHeight = (int)(currentFrame.getHeight() / factor);
            g.drawImage(currentFrame, 0,0,this.getWidth(), frameHeight, null);
        }
        repaint();
    }

    public void updateFrame(String imageBase64String){
        try {
            byte[] imageByte = decoder.decodeBuffer(imageBase64String);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            currentFrame = ImageIO.read(bis);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getCurrentFrame() {
        return currentFrame;
    }

    public double getFactor() {
        return factor;
    }

    public String getSocketId() {
        return socketId;
    }

    public int getShortId() {
        return shortId;
    }
}
