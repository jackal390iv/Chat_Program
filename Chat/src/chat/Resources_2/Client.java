package chat.Resources_2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Jonathan Butler
 */
public class Client extends Thread {

    public Client(InetAddress connectedIPAddress, int connectedPortAddress) {
        try {
            while (true) {
                Socket socket = new Socket(connectedIPAddress, connectedPortAddress);
                InputStream inStream = socket.getInputStream();
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
                System.out.println(bReader.readLine());

                sleep((int) (Math.random() * 1000));
            }

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }
}
