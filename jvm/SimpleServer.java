import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Source https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html
public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening on port 8080");
   
        while (true) {
			try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
