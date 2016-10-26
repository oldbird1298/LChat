/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatConnection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author dgerontop
 */
public class ConnectToServer extends Thread {

    DatagramSocket sock = null;
    DatagramSocket sock_in = null;

    public void sendData(String ip, int port, String msg) {
        try {
            sock = new DatagramSocket();
            byte[] buffer = msg.getBytes();
            InetAddress svr = InetAddress.getByName(ip);
            DatagramPacket outgoing = new DatagramPacket(buffer, buffer.length, svr, port);
            sock.send(outgoing);

        } catch (IOException e) {
            System.err.println("IOException " + e);

        }

    }

    public String receiveData() {
        String msg = null;
        try {
            sock_in = new DatagramSocket(27985);
            while (true) {
                byte[] bf = new byte[65536];
                DatagramPacket incoming = new DatagramPacket(bf, bf.length);
                sock_in.receive(incoming);

                byte[] data = incoming.getData();
                msg = new String(data, 0, incoming.getLength());
            }
        } catch (IOException e) {
            System.err.println("IOException : " + e);

        }
        return msg;

    }

}
