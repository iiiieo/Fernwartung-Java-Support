public class Main {

    private static Main main;
    private final String URL = "http://localhost:3000/";
    private Connection connection;
    private String ID;
    private Status status;

    public Main() {
        if (this.main == null) {
            this.main = this;
        }
        connection = new Connection(URL);
        this.status = new Status();
        connection.getEmitter().requestStatus();
        VideoStream stream = new VideoStream(connection);
        stream.start();
    }



    public static void main(String[] args) {
        System.out.println("Start");
        new Main();
    }

}
