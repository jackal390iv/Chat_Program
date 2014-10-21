/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.Server;

/**
 *
 * @author alfred
 */
public class clients {

    private String hostName=null;
    private String ipAdress;
    private int portAdress;

    public clients(String hostName, String ipAdress, int portAdress) {
        this.hostName = hostName;
        this.ipAdress = ipAdress;
        this.portAdress = portAdress;
    }
    
    public clients(String ipAdress, int portAdress){
        this.ipAdress = ipAdress;
        this.portAdress = portAdress;
    }
    
    public clients() {

    }

    public String get_hostName() {
        return hostName;
    }

    public void set_hostName(String hostName) {
        this.hostName = hostName;
    }

    public String get_ipAdress() {
        return ipAdress;
    }

    public void set_ipAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public int get_portAdress() {
        return portAdress;
    }

    public void set_portAdress(int portAdress) {
        this.portAdress = portAdress;
    }
}
