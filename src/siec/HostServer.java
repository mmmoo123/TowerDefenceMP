package siec;

import java.net.*;
import java.io.*;

public class HostServer {
    ServerSocket ss;
    Socket s;

    HostServer(int port){
        try {
            ss = new ServerSocket(port);
            s = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Klient sie polaczyl!");
    }
}
