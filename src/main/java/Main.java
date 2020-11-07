public class Main {

    private static Main main;
    private final String URL = "http://localhost:3000/";
    private Connection connection;
    private Frame frame;

    public Main() {
        if (this.main == null) {
            this.main = this;
        }
        connection = new Connection(URL);
        this.frame = new Frame(800, 600);

    }

    public void updateFrame(String data){
        String imageBase64String = data;
        frame.getScreenPanel().updateFrame(imageBase64String);
    }

    public Frame getFrame() {
        return frame;
    }

    public String getURL() {
        return URL;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public static Main getMain() {
        return main;
    }

    public static void main(String[] args) {
        System.out.println("Start");
        new Main();
    }

}
