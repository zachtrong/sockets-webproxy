
public class ServerApplication {

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start(6666);
    }
}
