/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.Client;

import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author alfred
 */
public class recieveData extends Thread {

    private DatagramSocket socket;

    public recieveData(DatagramSocket socket) {
        try {
            this.socket = socket;

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }

    public void run() {
        try {
            Boolean check = true;
            byte[] messageByte = new byte[65508];

            do {
                DatagramPacket packet_Recieved = new DatagramPacket(messageByte, messageByte.length);
                socket.receive(packet_Recieved);
                //System.out.println("Packet Recieved: " + packet_Recieved.getPort() + " " + packet_Recieved.getAddress());

                String message = new String(packet_Recieved.getData(), packet_Recieved.getOffset(), packet_Recieved.getLength());
                System.out.println("Recieved: " + message);

                sleep((int) (Math.random() * 1000));

            } while (check == true);

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }
}