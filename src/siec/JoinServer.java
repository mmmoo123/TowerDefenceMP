package siec;

import java.net.*;
import java.io.*;

public class JoinServer {
    Socket s;

    JoinServer(int port){
        try {
            s = new Socket("185.161.93.50", port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Udało się połączyć!");
    }
}
