package chat.Resources_2;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 *
 * @author Jonathan Butler
 */
public class Server {

    private ServerSocket socket;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            Boolean check = false;
            Scanner input;
            String connectedIPAddress;
            int connectedPortAddress;

            socket = new ServerSocket(0);
            System.out.println("Socket Port: " + socket.getLocalPort());
            System.out.println("IPAddress: " + InetAddress.getLocalHost().getHostAddress());

            do {
                input = new Scanner(System.in);
                System.out.println("\n" + "Please enter conection Port Address: ");
                connectedPortAddress = input.nextInt();

                input = new Scanner(System.in);
                System.out.println("Please enter conection IPAddress: ");
                connectedIPAddress = input.nextLine();

                if (InetAddress.getByName(connectedIPAddress).isReachable(5000)) {
                    System.out.println("found");
                    check = true;
                } else {
                    System.out.println("ERROR: connection not found.");
                }
            } while (check == false);

            new Client(InetAddress.getByName(connectedIPAddress), connectedPortAddress).start();
            new ServerHelper(socket).start();

        } catch (Exception ex) {
            System.out.println("Cause: " + ex.getCause());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Local Message: " + ex.getLocalizedMessage());
            //ex.printStackTrace();*/
        }
    }
}
