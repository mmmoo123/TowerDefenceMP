package siec;

import com.dosse.upnp.UPnP;
import gra.GameState;
import model.Sprite;
import model.Tower;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;

public class Communication {

    int portNumber;
    String ipAddres;
    DatagramSocket socket;

    public Communication(int portNumber, String ipAddres, boolean isHost) throws IOException {

        this.ipAddres = ipAddres;

        if(isHost) {
            socket = new DatagramSocket(portNumber);
            //this.portNumber = portNumber + 1;
            this.portNumber = portNumber;
        }
        else {
            //socket = new DatagramSocket(portNumber + 1);
            socket = new DatagramSocket(portNumber);
            this.portNumber = portNumber;
        }
    }

    public GameState reciveGameState() throws IOException, ClassNotFoundException {

        byte[] buffer = new byte[65535];

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramPacket);

        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(buffer));
        GameState gs = (GameState) inputStream.readObject();

        return gs;
    }


    public void sendGameState(GameState gs) throws IOException{

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(gs);
        outputStream.close();

        byte[] buffer = out.toByteArray();

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ipAddres), portNumber);

        socket.send(datagramPacket);
    }
}