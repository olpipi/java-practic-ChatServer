/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.client;

import server.client.ClientProxy;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oleg
 */

/**
 * Singleton class.
 * Handler for all ClientProxy. Define Map for <ClientId, ClientProxy>
 *
 */
public class ProxyHandler {

    /**
     * Map for Client and its Proxy
     */
    HashMap<Client, ClientProxy> clientProxyList = null;
    
    ProxyHandler() {
        initialize();
    }

    public static class ProxyHolder {
	    public static final ProxyHandler HOLDER_INSTANCE = new ProxyHandler();
    }
    
    public static ProxyHandler getInstance() {
        return ProxyHolder.HOLDER_INSTANCE;
    }
    
    private void initialize() {
        this.clientProxyList = new HashMap<>();
    }

    /**
     * Check if this client has its proxy
     * @param client
     * @return true if client has its proxy
     */
    public boolean isExist(Client client) {
        return clientProxyList.containsKey(client);
    }

    /**
     * Add new ClientProxy if proxy does not exist for this client
     * @param newClient - client which requared to create proxy
     * @return ClientProxy
     */
    public ClientProxy addClient (Client newClient) {
        ClientProxy proxy = null;
        if (!isExist(newClient)) {
            proxy = new ClientProxy(newClient);
            clientProxyList.put(newClient, proxy);
        }
        return proxy;
    }

    /**
     * Delete client and its proxy
     * @param client
     */
    void deleteClient(Client client) {
        if (isExist(client)) {
            clientProxyList.remove(client);
        }
    }
    
    public ClientProxy findClientProxy (Client client) {
        return clientProxyList.get(client) ;
    }
      
}
