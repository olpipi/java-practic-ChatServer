/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.client;

import java.net.Socket;
import java.util.WeakHashMap;

/**
 *
 * @author Oleg
 */
public class ClientFactory {
    
    private static int nextClientId;
    
    private static WeakHashMap<String, Client> weakClientMap = new WeakHashMap();

    
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
        String clientId = getIdentifierFromName(clientName);
        if (weakClientMap.containsKey(clientId)) {
            return weakClientMap.get(clientId);
        } else {
            Client newClient = new Client(clientName, clientSocket);
            //newClient.setId(clientId);
            weakClientMap.
        }
    }
    
    public static Client createClient(Socket clientSocket){
        return createClient(ClientFactory.getInstance().getDefaultName(), clientSocket);
    }
    
    static private String getDefaultName () {
        return Integer.toString(nextClientId++);
    }
    
    static public String getIdentifierFromName (String clientName){
        return clientName;
    }
    
}
