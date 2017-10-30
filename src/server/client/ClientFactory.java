/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.client;

import java.net.Socket;

/**
 *
 * @author Oleg
 */
public class ClientFactory {
    
    private int nextClientId = 0;

    public static class FactoryHolder {
	    static final ClientFactory HOLDER_INSTANCE = new ClientFactory();
    }
    
    public static ClientFactory getInstance() {
        return FactoryHolder.HOLDER_INSTANCE;
    }
    
    public Client createClient(String clientName, Socket clientSocket){
        return new Client(clientName, clientSocket);
    }
    
    public Client createClient(Socket clientSocket){
        return new Client(this.getDefaultName(), clientSocket);
    }
    
     private String getDefaultName () {
        return Integer.toString(nextClientId++);
    }
    
}
