import java.net.*;
import java.io.*;

public class JoinServer {
    Socket s;

    JoinServer(int port){
        try {
            s = new Socket("localhost", port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Udało się połączyć!");
    }
}
