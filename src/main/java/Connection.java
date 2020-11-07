import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class Connection {
    private Socket socket;
    private ConnectionHandler handler;
    private ConnectionEmitter emitter;

    public Connection(String url) {
        try {
            socket = IO.socket(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.handler = new ConnectionHandler(this);
        this.emitter = new ConnectionEmitter(this);
        socket.connect();
    }

    public ConnectionHandler getHandler() {
        return handler;
    }

    public void setHandler(ConnectionHandler handler) {
        this.handler = handler;
    }

    public ConnectionEmitter getEmitter() {
        return emitter;
    }

    public void setEmitter(ConnectionEmitter emitter) {
        this.emitter = emitter;
    }

    public class ConnectionEmitter {
        private Connection connection;

        public ConnectionEmitter(Connection connection) {
            this.connection = connection;
        }

        public void emit(String event, Object obj) {
            socket.emit(event, obj);
        }
        public void emitString(String event, String message) {
            socket.emit(event, message);
        }
        public void emitInt(String event, int number) {
            socket.emit(event, number);
        }
    }

    public class ConnectionHandler {
        public ConnectionHandler(Connection connection) {
            handleSocketEvents();
        }

        private void handleSocketEvents() {
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Connected");
                }
            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Disconnected");
                }
            }).on("clientID", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String id = (String) args[0];
                }
            }).on("stream", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String data = (String) args[0];
                    Main.getMain().updateFrame(data);
                }
            });
        }
    }
}
