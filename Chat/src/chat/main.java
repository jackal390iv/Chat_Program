/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class main {

    private int optionPanel;

    public static void main(String[] args) {
        new main();
    }

    public main() {
        chooseType();

        if (optionPanel == 0) {

        } else if (optionPanel == 1) {
            chat.Client.mainUI client = new chat.Client.mainUI();
            client.start();
        }
    }

    private void chooseType() {
        String[] jButtons = {"Host Server", "Client"};
        optionPanel = JOptionPane.showOptionDialog(null, "Host Sever or Client?", "Welcome To The Chat", JOptionPane.INFORMATION_MESSAGE, 1, null, jButtons, jButtons[1]);
    }
}
