package siec;

import java.net.*;
import java.io.*;

public class JoinServer {
    Socket s;

    JoinServer(int port){
        try {
            s = new Socket("79.185.144.80", port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Udalo, sie poloczyc!");
    }
}
