/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.Client;

import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author alfred
 */
public class sendData extends Thread {

    private DatagramSocket socket;
    private DatagramPacket packet_Sent;
    private String connectedIPAddress;
    private int connectedPortAddress;

    public sendData(DatagramSocket socket, DatagramPacket packet_Sent, String connectedIPAddress, int connectedPortAddress) {
        try {
            this.socket = socket;
            this.packet_Sent = packet_Sent;
            this.connectedIPAddress = connectedIPAddress;
            this.connectedPortAddress = connectedPortAddress;

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }

    public void run() {
        try {
            Boolean end = false;
            Scanner input;
            String message;

            do {
                input = new Scanner(System.in);
                System.out.println("Send: ");
                message = input.nextLine();
                if (message.equals("EXIT")) {
                    end = true;
                } else {
                    packet_Sent = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName(connectedIPAddress), connectedPortAddress);
                    //System.out.println("Packet Sent: " + packet_Sent.getPort() + " " + packet_Sent.getAddress());

                    socket.send(packet_Sent);
                }
                sleep((int) (Math.random() * 1000));

            } while (end == false);

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
        System.exit(0);
    }
}
