package siec;

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

    public Communication(int portNumber, String ipAddres) throws IOException {

        this.portNumber = portNumber;
        this.ipAddres = ipAddres;
        socket = new DatagramSocket(portNumber);

    }

    public List<Tower> reciveTowers() throws IOException, ClassNotFoundException {

        byte[] buffer = new byte[65535];

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(datagramPacket);

        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(buffer));
        List<Tower> towerList = (List<Tower>) inputStream.readObject();

        return towerList;
    }

    public void sendTowers(List<Tower> towerList) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(towerList);
        outputStream.close();

        byte[] buffer = out.toByteArray();

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ipAddres), portNumber);
        socket.send(datagramPacket);
    }
}
