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
    
    private static int nextClientId;
    
    static {
        nextClientId = 0;        
    }
    
    public static class FactoryHolder {
	public static final ClientFactory HOLDER_INSTANCE = new ClientFactory();
    }
    
    public static ClientFactory getInstance() {
        return FactoryHolder.HOLDER_INSTANCE;
    }
    
    public static Client createClient(String clientName, Socket clientSocket){
        return new Client(clientName, clientSocket);
    }
    
    public static Client createClient(Socket clientSocket){
        return new Client(ClientFactory.getInstance().getDefaultName(), clientSocket);
    }
    
    static private String getDefaultName () {
        return Integer.toString(nextClientId++);
    }
    
}
