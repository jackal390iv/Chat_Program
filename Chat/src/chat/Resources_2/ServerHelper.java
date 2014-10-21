package chat.Resources_2;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jonathan Butler
 */
public class ServerHelper extends Thread {

    public ServerHelper(ServerSocket socket) {
        try {
            while (true) {
                Socket client = socket.accept();
                PrintWriter pWriter = new PrintWriter(client.getOutputStream(), true);
                pWriter.println("Hello World");

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
