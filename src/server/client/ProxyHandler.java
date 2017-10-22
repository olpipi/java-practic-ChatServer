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
public class ProxyHandler {

    static HashMap<Client, ClientProxy> clientProxyList = null;
    
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
    
    public static boolean isExist(Client client) {
        if (clientProxyList.containsKey(client)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static ClientProxy addClient (Client newClient) {
        ClientProxy proxy = null;
        if (!isExist(newClient)) {
            proxy = new ClientProxy(newClient);
            clientProxyList.put(newClient, proxy);
        }
        return proxy;
    }
    
    public static void deleteClient (Client client) {
        if (isExist(client)) {
            clientProxyList.remove(client);
        }
    }
    
    public static ClientProxy findClientProxy (Client client) {
        return clientProxyList.get(client) ;
    }
      
}
