/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.Server;

import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class serverHub {

    private ServerSocket socket;

    public serverHub() {
        startServer();
    }

    private void startServer() {
        String hostName = null;
        String ipAdress = null;
        int portAdress = -1;
        try {
            socket = new ServerSocket(0);
            hostName = socket.getInetAddress().getHostName();
            ipAdress = socket.getInetAddress().getHostAddress();
            portAdress = socket.getLocalPort();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cause: " + ex.getCause() + "\n" + "Message: " + ex.getMessage() + "\n" + "Local Message: " + ex.getLocalizedMessage(), "Error", 0);
            System.exit(0);
        }       
        new recieveData().start();
        new sendData().start();
        JOptionPane.showMessageDialog(null, "Host Name: " + hostName + "\n" + "IP-Address: " + ipAdress + "\n" + "Port-Address: " + portAdress, "Server Hub", 1);
    }
}
